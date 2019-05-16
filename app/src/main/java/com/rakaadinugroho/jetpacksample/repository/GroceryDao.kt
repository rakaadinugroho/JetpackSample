package com.rakaadinugroho.jetpacksample.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rakaadinugroho.jetpacksample.entities.Grocery

@Dao
interface GroceryDao {
    @Query("SELECT * FROM grocery ORDER BY id DESC")
    fun getGroceries(): List<Grocery>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: Grocery)

    @Query("DELETE FROM grocery")
    fun deleteGroceries()

    @Query("SELECT * FROM grocery WHERE id = :id")
    fun find(id: Int) : Grocery
}