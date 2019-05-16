package com.rakaadinugroho.jetpacksample.repository

import android.app.Application
import android.os.AsyncTask
import androidx.room.*
import com.rakaadinugroho.jetpacksample.entities.Grocery

@Database(entities = [Grocery::class], version = 1)
abstract class GroceryDatabase: RoomDatabase() {

    abstract fun groceryDao(): GroceryDao

    companion object {
        private val lock = Any()
        private const val DB_NAME = "Grocery.db"
        private var INSTANCE: GroceryDatabase? = null

        fun getInstance(application: Application): GroceryDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        application,
                        GroceryDatabase::class.java,
                        DB_NAME)
                        .allowMainThreadQueries()
                        .build()
                }
                return INSTANCE!!
            }
        }

        fun prePopulate(database: GroceryDatabase, groceries: List<Grocery>) {
            groceries.forEach {
                AsyncTask.execute { database.groceryDao().insert(it) }
            }
        }
    }
}