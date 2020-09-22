package org.d3if1008.dicodingexpert.di

import dagger.Component
import org.d3if1008.dicodingexpert.core.di.CoreComponent
import org.d3if1008.dicodingexpert.detail.DetailFootballActivity
import org.d3if1008.dicodingexpert.favorite.FavoriteFragment
import org.d3if1008.dicodingexpert.home.HomeFragment

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailFootballActivity)
}