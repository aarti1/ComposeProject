package com.example.myapplication.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.myapplication.data.remote.NewsApi
import com.example.myapplication.data.remote.NewsPagingSource
import com.example.myapplication.data.remote.SearchNewsPagingSource
import com.example.myapplication.db.NewsDao
import com.example.myapplication.domain.model.Article
import com.example.myapplication.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(private val newsApi: NewsApi,private val newsDao: NewsDao): NewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(newsApi = newsApi, sources = sources.joinToString(separator = ","))
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    api = newsApi,
                    searchQuery = searchQuery,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

/*    override suspend fun upsertArticle(article: Article) {
        newsDao.upsert(article)
    }

    override suspend fun deleteArticle(article: Article) {
        newsDao.delete(article)
    }

    override fun getArticles(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

    override suspend fun getArticle(url: String): Article? {
        return newsDao.getArticle(url = url)
    }*/
}