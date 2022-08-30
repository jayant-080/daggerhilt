package com.example.daggerhilt

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named


@Module
@InstallIn(ActivityComponent::class)
abstract class RegistrationModule {


    @Named("local")
    @Binds
    abstract fun provideRegisterApi(saveToLocal: SaveToLocal) : RegisterApi

    @Named("mongo")
    @Binds
    abstract fun provideSaveToMongo(registrationRepository: RegistrationRepository):RegisterApi


}