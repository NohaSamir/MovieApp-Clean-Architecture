package com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoud.mohammed.movieapp.base.BaseViewModel
import com.mahmoud.mohammed.movieapp.common.SingleLiveEvent
import com.mahmoud.mohammed.movieapp.domain.Mapper
import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.domain.usecases.GetPopularMovies
import com.mahmoud.mohammed.movieapp.presentation.entities.Movie
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class PopularMoviesViewModel
constructor(
        private val getPopularMovies: GetPopularMovies) : ViewModel() {
    var viewState: MutableLiveData<PopularMoviesViewState> = MutableLiveData()
    var errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()


    init {
        viewState.value = PopularMoviesViewState()
    }

    fun getPopularMovies() {
        viewModelScope.launch (){
            val movies = getPopularMovies.getMovies()
            val newState = viewState.value?.copy(showLoading = false, movies = movies)
            viewState.value = newState
        }

        /*addDisposable(getPopularMovies.observable()
                .flatMap { movieEntityMovieMapper.observable(it) }
                .subscribe({ movies ->
                    viewState.value?.let {
                        val newState = this.viewState.value?.copy(showLoading = false, movies = movies)
                        this.viewState.value = newState
                        this.errorState.value = null
                    }

                }, {
                    viewState.value = viewState.value?.copy(showLoading = false)
                    errorState.value = it
                }))*/
    }


}