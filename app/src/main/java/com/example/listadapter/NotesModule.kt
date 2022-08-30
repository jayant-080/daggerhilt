package com.example.listadapter

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NotesModule {


    @Singleton
    @Binds
    abstract fun provideOnRemove(removeImp: RemoveNoteImple) : OnRemoveNote



}