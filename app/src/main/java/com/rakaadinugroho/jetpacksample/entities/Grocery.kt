package com.rakaadinugroho.jetpacksample.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Grocery(
    var name: String = "",
    var amount: Int = 0,
    var total: Int = 0,
    var description: String = "",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)