package com.mahmoud.mohammed.movieapp.domain

import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.domain.entities.Optional
import io.reactivex.Observable

interface MoviesCache {

    fun clear()
    fun save(movieEntity: MovieEntity)
    fun remove(movieEntity: MovieEntity)
    fun saveAll(movieEntities: List<MovieEntity>)
    fun getAll(): List<MovieEntity>
    fun get(movieId: Int): Observable<Optional<MovieEntity>>
    fun isEmpty(): Boolean
}