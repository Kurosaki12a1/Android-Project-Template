package com.android.template.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.template.data.data_source.local.dao.ExampleDao
import com.android.template.data.model.entity.EntityExample

@Database(entities = [EntityExample::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
}