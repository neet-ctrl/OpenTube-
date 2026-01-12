/*
 * SPDX-FileCopyrightText: 2020-2023 OpenTube contributors <https://opentube.net>
 * SPDX-FileCopyrightText: 2025 OpenTube e.V. <https://opentube-ev.de>
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package org.schabi.opentube.database.stream

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Ignore
import org.schabi.opentube.database.LocalItem
import org.schabi.opentube.database.history.model.StreamHistoryEntity
import org.schabi.opentube.database.stream.model.StreamEntity
import org.schabi.opentube.database.stream.model.StreamStateEntity.Companion.STREAM_PROGRESS_MILLIS
import org.schabi.opentube.extractor.stream.StreamInfoItem
import org.schabi.opentube.util.image.ImageStrategy
import java.time.OffsetDateTime

data class StreamStatisticsEntry(
    @Embedded
    val streamEntity: StreamEntity,

    @ColumnInfo(name = STREAM_PROGRESS_MILLIS, defaultValue = "0")
    val progressMillis: Long,

    @ColumnInfo(name = StreamHistoryEntity.JOIN_STREAM_ID)
    val streamId: Long,

    @ColumnInfo(name = STREAM_LATEST_DATE)
    val latestAccessDate: OffsetDateTime,

    @ColumnInfo(name = STREAM_WATCH_COUNT)
    val watchCount: Long
) : LocalItem {

    override val localItemType: LocalItem.LocalItemType
        get() = LocalItem.LocalItemType.STATISTIC_STREAM_ITEM

    @Ignore
    fun toStreamInfoItem(): StreamInfoItem {
        return StreamInfoItem(
            streamEntity.serviceId,
            streamEntity.url,
            streamEntity.title,
            streamEntity.streamType
        ).apply {
            duration = streamEntity.duration
            uploaderName = streamEntity.uploader
            uploaderUrl = streamEntity.uploaderUrl
            thumbnails = ImageStrategy.dbUrlToImageList(streamEntity.thumbnailUrl)
        }
    }

    companion object {
        const val STREAM_LATEST_DATE = "latestAccess"
        const val STREAM_WATCH_COUNT = "watchCount"
    }
}
