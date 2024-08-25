package com.android.template.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.template.data.model.entity.EntityExample
import kotlinx.coroutines.flow.Flow

@Dao
interface ExampleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(example: EntityExample)

    @Query("SELECT * FROM example_table ORDER BY name ASC")
    fun getAllUsers(): Flow<List<EntityExample>>
}