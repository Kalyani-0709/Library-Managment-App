package com.example.librarymanagementapp

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database( entities = [Book::class], version = 1 , exportSchema = false)
abstract  class BookRoomDatabase  : RoomDatabase() {

    // interface
    abstract  fun bookDao() : BookDao

   companion object{

       @Volatile
       private var INSTANCE : BookRoomDatabase? = null

       fun getDatabase(
           context: Context,   // MainActivity( Context )  Application
           scope: CoroutineScope   //  CoroutineScope( SupervisorJob() )
       ) : BookRoomDatabase{

           return  INSTANCE?: synchronized( this ){

               val instance = Room.databaseBuilder(
                   context.applicationContext,
                   BookRoomDatabase::class.java,
                   "book_database"
               )
                   .fallbackToDestructiveMigration(    )
                   .addCallback( BookDatabaseCallback( scope )  )    // hook
                   .build()
               INSTANCE = instance
               instance
           }
       }

       // lets use the WordDao here to work upon CRUD opreations
       private class BookDatabaseCallback(
           private val scope: CoroutineScope
       ) : RoomDatabase.Callback() {

           override fun onCreate(db: SupportSQLiteDatabase) {
               super.onCreate(db)
               INSTANCE?.let { database ->
                   scope.launch {
                       populateDatabase(database.bookDao())
                   }
               }
           }

           suspend fun populateDatabase(bookDao: BookDao) {
               // Delete all content here.

              // wordDao.deleteAll()

               // Add sample words.
               var book = Book("Java",123,"abc",20)
               bookDao.insert(book)
               book = Book("Kotlin!",890,"xyz",30)
               bookDao.insert(book)
           }
       }
   }

}