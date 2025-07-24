package com.example.mymerce.di

import com.example.mymerce.data.remote.ApiCall
import com.example.mymerce.data.repository.GreetingRepositoryImpl
import com.example.mymerce.data.repository.ProductRepositoryImpl
import com.example.mymerce.data.repository.RecipeRepositoryImpl
import com.example.mymerce.domain.GreetingRepository
import com.example.mymerce.domain.ProductRepository
import com.example.mymerce.domain.RecipeRepository
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
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideProductApi(retrofit: Retrofit): ApiCall =
        retrofit.create(ApiCall::class.java)

    @Provides
    @Singleton
    fun provideProductRepository(api: ApiCall): ProductRepository {
        return ProductRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideRecipeRepository(api: ApiCall): RecipeRepository {
        return RecipeRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGreetingRepository(): GreetingRepository {
        return GreetingRepositoryImpl()
    }
}
