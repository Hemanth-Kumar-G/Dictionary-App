package com.hemanthdev.dictionary.feat_dictionary.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.hemanthdev.dictionary.feat_dictionary.data.local.Converters
import com.hemanthdev.dictionary.feat_dictionary.data.local.WordInfoDatabase
import com.hemanthdev.dictionary.feat_dictionary.data.remote.DictionaryApi
import com.hemanthdev.dictionary.feat_dictionary.data.repository.WordInfoRepositoryImpl
import com.hemanthdev.dictionary.feat_dictionary.data.util.GsonParser
import com.hemanthdev.dictionary.feat_dictionary.domain.repository.WordInfoRepository
import com.hemanthdev.dictionary.feat_dictionary.domain.use_case.GetWordInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val DB_NAME = "dictionary_db"

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase =
        Room.databaseBuilder(
            app,
            WordInfoDatabase::class.java,
            DB_NAME
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi =
        Retrofit
            .Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: WordInfoDatabase,
        api: DictionaryApi
    ): WordInfoRepository =
        WordInfoRepositoryImpl(api, db.dao)

    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo =
        GetWordInfo(repository)

}