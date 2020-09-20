package org.d3if1008.dicodingexpert

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if1008.dicodingexpert.domain.usecase.FootballUseCase

class ViewModelFactory private constructor(private val footballUsecase: FootballUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideFootballUseCase(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(footballUsecase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(footballUsecase) as T
            }
            modelClass.isAssignableFrom(DetailFootballViewModel::class.java) -> {
                DetailFootballViewModel(footballUsecase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}