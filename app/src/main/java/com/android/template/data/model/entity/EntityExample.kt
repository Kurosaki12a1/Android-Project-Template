package com.android.template.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "example_table")
data class EntityExample(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val message: String,
    val name: String,
    val description: String
)