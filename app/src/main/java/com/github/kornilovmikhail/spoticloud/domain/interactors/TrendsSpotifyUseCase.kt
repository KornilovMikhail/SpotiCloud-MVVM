package com.github.kornilovmikhail.spoticloud.domain.interactors

import com.github.kornilovmikhail.spoticloud.di.SpotifyQualifier
import com.github.kornilovmikhail.spoticloud.domain.interfaces.TracksRepository
import com.github.kornilovmikhail.spoticloud.domain.model.Track
import io.reactivex.Single
import javax.inject.Inject

class TrendsSpotifyUseCase @Inject constructor(
    @param:SpotifyQualifier private val spotifyTrackRepository: TracksRepository
) {

    fun getTrendsTracks(): Single<List<Track>> {
        return spotifyTrackRepository.getTrendTracks()
    }
}
