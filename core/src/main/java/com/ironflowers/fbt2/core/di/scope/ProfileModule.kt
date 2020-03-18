package com.ironflowers.fbt2.core.di.scope

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ProfileModule {
    @Module
    companion object {
        @Provides
        fun provideName() = ""
    }

    @Binds
    abstract fun bindBlaBla(blablaImpl: BlablaImpl): Blabla
}