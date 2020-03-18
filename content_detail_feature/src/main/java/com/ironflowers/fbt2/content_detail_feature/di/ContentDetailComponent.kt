package com.ironflowers.fbt2.content_detail_feature.di

import com.ironflowers.fbt2.content_detail_feature.ui.DetailFragment
import com.ironflowers.fbt2.content_detail_feature.ui.di.DetailFragmentModule
import com.ironflowers.fbt2.core.di.CoreComponent
import com.ironflowers.fbt2.core.di.scope.FragmentScope
import dagger.BindsInstance
import dagger.Component

@FragmentScope // add scope, because we cannot use the same scope as the component we depend upon (CoreComponent).
@Component(
    modules = [ContentDetailModule::class], // this feature's main/root module, it might contain submodules.
    dependencies = [CoreComponent::class] // so we can use all objects that CoreComponent provides
)
interface ContentDetailComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: DetailFragment,
            coreComponent: CoreComponent
        ): ContentDetailComponent
    }

    fun inject(detailFragment: DetailFragment)
}