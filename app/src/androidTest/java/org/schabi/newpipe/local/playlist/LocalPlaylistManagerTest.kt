package org.schabi.opentube.local.playlist

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.schabi.opentube.database.AppDatabase
import org.schabi.opentube.database.stream.model.StreamEntity
import org.schabi.opentube.extractor.stream.StreamType
import org.schabi.opentube.testUtil.TestDatabase
import org.schabi.opentube.testUtil.TrampolineSchedulerRule

class LocalPlaylistManagerTest {

    private lateinit var manager: LocalPlaylistManager
    private lateinit var database: AppDatabase

    @get:Rule
    val trampolineScheduler = TrampolineSchedulerRule()

    @Before
    fun setup() {
        database = TestDatabase.createReplacingOpenTubeDatabase()
        manager = LocalPlaylistManager(database)
    }

    @After
    fun cleanUp() {
        database.close()
    }

    @Test
    fun createPlaylist() {
        val NEWPIPE_URL = "https://opentube.net/"
        val stream = StreamEntity(
            serviceId = 1, url = NEWPIPE_URL, title = "title",
            streamType = StreamType.VIDEO_STREAM, duration = 1, uploader = "uploader",
            uploaderUrl = NEWPIPE_URL
        )

        val result = manager.createPlaylist("name", listOf(stream))

        // This should not behave like this.
        // Currently list of all stream ids is returned instead of playlist id
        result.test().await().assertValue(listOf(1L))
    }

    @Test
    fun createPlaylist_emptyPlaylistMustReturnEmpty() {
        val result = manager.createPlaylist("name", emptyList())

        // This should not behave like this.
        // It should throw an error because currently the result is null
        result.test().await().assertComplete()
        manager.playlists.test().awaitCount(1).assertValue(emptyList())
    }

    @Test()
    fun createPlaylist_nonExistentStreamsAreUpserted() {
        val stream = StreamEntity(
            serviceId = 1, url = "https://opentube.net/", title = "title",
            streamType = StreamType.VIDEO_STREAM, duration = 1, uploader = "uploader",
            uploaderUrl = "https://opentube.net/"
        )
        database.streamDAO().insert(stream)
        val upserted = StreamEntity(
            serviceId = 1, url = "https://opentube.net/2", title = "title2",
            streamType = StreamType.VIDEO_STREAM, duration = 1, uploader = "uploader",
            uploaderUrl = "https://opentube.net/"
        )

        val result = manager.createPlaylist("name", listOf(stream, upserted))

        result.test().await().assertComplete()
        database.streamDAO().getAll().test().awaitCount(1).assertValue(listOf(stream, upserted))
    }
}
