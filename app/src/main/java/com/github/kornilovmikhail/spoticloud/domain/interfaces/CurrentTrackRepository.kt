package com.github.kornilovmikhail.spoticloud.domain.interfaces

import com.github.kornilovmikhail.spoticloud.domain.model.Track
import io.reactivex.Observable

interface CurrentTrackRepository {

    fun setCurrentTrack(track: Track)

    fun observeCurrentTrack(): Observable<Track>
}
