package com.example.myapplication.di

import android.app.Application
import androidx.room.Room
import com.example.myapplication.data.manger.LocalUserMangerImpl
import com.example.myapplication.data.remote.NewsApi
import com.example.myapplication.data.repository.NewsRepositoryImpl
import com.example.myapplication.db.NewsDao
import com.example.myapplication.db.NewsDatabase
import com.example.myapplication.db.NewsTypeConvertor
import com.example.myapplication.domain.manger.LocalUserManger
import com.example.myapplication.domain.repository.NewsRepository
import com.example.myapplication.domain.usecases.app_entry.AppEntryUseCases
import com.example.myapplication.domain.usecases.app_entry.ReadAppEntry
import com.example.myapplication.domain.usecases.app_entry.SaveAppEntry
import com.example.myapplication.domain.usecases.news.DeleteArticle
import com.example.myapplication.domain.usecases.news.GetArticle
import com.example.myapplication.domain.usecases.news.GetArticles
import com.example.myapplication.domain.usecases.news.GetNews
import com.example.myapplication.domain.usecases.news.NewsUseCases
import com.example.myapplication.domain.usecases.news.SearchNews
import com.example.myapplication.domain.usecases.news.UpsertArticle
import com.example.myapplication.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )


    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi,newsDao: NewsDao): NewsRepository {
        return NewsRepositoryImpl(newsApi, newsDao)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        repository: NewsRepository,newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(repository),
            searchNews = SearchNews(repository),
            upsertArticle = UpsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            getArticles = GetArticles(newsDao),
            getArticle = GetArticle(newsDao)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(newsDatabase: NewsDatabase): NewsDao = newsDatabase.newsDao

}