package com.ironflowers.fbt2.content_detail_feature.ui.di

import com.ironflowers.fbt2.content_detail_feature.ui.DetailFragment
import com.ironflowers.fbt2.content_detail_feature.ui.DetailFragmentArgs
import com.ironflowers.fbt2.content_detail_feature.ui.vm.DetailViewModel
import com.ironflowers.fbt2.core.domain.content.ContentUseCases
import com.ironflowers.fbt2.core.ui.common.DispatchersProvider
import com.ironflowers.fbt2.core.ui.common.extensions.getViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Named

const val DI_DETAIL_FRAGMENT_CONTENT_ID = "DetailFragmentContentId"

@Module
class DetailFragmentModule {

    @Provides
    @Named(DI_DETAIL_FRAGMENT_CONTENT_ID)
    fun provideContentId(fragment: DetailFragment): String =
        fragment.arguments?.let { DetailFragmentArgs.fromBundle(it) }?.contentId ?: ""

    @Provides
    fun provideOverviewViewModel(
        fragment: DetailFragment,
        contentUseCases: ContentUseCases,
        @Named(DI_DETAIL_FRAGMENT_CONTENT_ID)
        contentId: String,
        dispatchersProvider: DispatchersProvider
    ): DetailViewModel =
        fragment.getViewModel {
            DetailViewModel(contentUseCases, contentId, dispatchersProvider)
        }
}