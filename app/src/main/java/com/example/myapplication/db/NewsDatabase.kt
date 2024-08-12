package com.example.myapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.domain.model.Article

@Database(entities = [Article::class], version = 1)
@TypeConverters(NewsTypeConvertor::class)
abstract class NewsDatabase: RoomDatabase() {
     abstract val newsDao: NewsDao
}