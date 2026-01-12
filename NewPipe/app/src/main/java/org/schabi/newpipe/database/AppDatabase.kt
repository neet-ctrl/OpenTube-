/*
 * SPDX-FileCopyrightText: 2017-2024 OpenTube contributors <https://opentube.net>
 * SPDX-FileCopyrightText: 2025 OpenTube e.V. <https://opentube-ev.de>
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package org.schabi.opentube.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.schabi.opentube.database.feed.dao.FeedDAO
import org.schabi.opentube.database.feed.dao.FeedGroupDAO
import org.schabi.opentube.database.feed.model.FeedEntity
import org.schabi.opentube.database.feed.model.FeedGroupEntity
import org.schabi.opentube.database.feed.model.FeedGroupSubscriptionEntity
import org.schabi.opentube.database.feed.model.FeedLastUpdatedEntity
import org.schabi.opentube.database.history.dao.SearchHistoryDAO
import org.schabi.opentube.database.history.dao.StreamHistoryDAO
import org.schabi.opentube.database.history.model.SearchHistoryEntry
import org.schabi.opentube.database.history.model.StreamHistoryEntity
import org.schabi.opentube.database.playlist.dao.PlaylistDAO
import org.schabi.opentube.database.playlist.dao.PlaylistRemoteDAO
import org.schabi.opentube.database.playlist.dao.PlaylistStreamDAO
import org.schabi.opentube.database.playlist.model.PlaylistEntity
import org.schabi.opentube.database.playlist.model.PlaylistRemoteEntity
import org.schabi.opentube.database.playlist.model.PlaylistStreamEntity
import org.schabi.opentube.database.stream.dao.StreamDAO
import org.schabi.opentube.database.stream.dao.StreamStateDAO
import org.schabi.opentube.database.stream.model.StreamEntity
import org.schabi.opentube.database.stream.model.StreamStateEntity
import org.schabi.opentube.database.subscription.SubscriptionDAO
import org.schabi.opentube.database.subscription.SubscriptionEntity

@TypeConverters(Converters::class)
@Database(
    version = Migrations.DB_VER_9,
    entities = [
        SubscriptionEntity::class,
        SearchHistoryEntry::class,
        StreamEntity::class,
        StreamHistoryEntity::class,
        StreamStateEntity::class,
        PlaylistEntity::class,
        PlaylistStreamEntity::class,
        PlaylistRemoteEntity::class,
        FeedEntity::class,
        FeedGroupEntity::class,
        FeedGroupSubscriptionEntity::class,
        FeedLastUpdatedEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun feedDAO(): FeedDAO
    abstract fun feedGroupDAO(): FeedGroupDAO
    abstract fun playlistDAO(): PlaylistDAO
    abstract fun playlistRemoteDAO(): PlaylistRemoteDAO
    abstract fun playlistStreamDAO(): PlaylistStreamDAO
    abstract fun searchHistoryDAO(): SearchHistoryDAO
    abstract fun streamDAO(): StreamDAO
    abstract fun streamHistoryDAO(): StreamHistoryDAO
    abstract fun streamStateDAO(): StreamStateDAO
    abstract fun subscriptionDAO(): SubscriptionDAO

    companion object {
        const val DATABASE_NAME: String = "opentube.db"
    }
}
