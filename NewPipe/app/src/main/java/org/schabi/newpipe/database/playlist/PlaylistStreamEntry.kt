/*
 * SPDX-FileCopyrightText: 2020-2023 OpenTube contributors <https://opentube.net>
 * SPDX-FileCopyrightText: 2025 OpenTube e.V. <https://opentube-ev.de>
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package org.schabi.opentube.database.playlist

import androidx.room.ColumnInfo
import androidx.room.Embedded
import org.schabi.opentube.database.LocalItem
import org.schabi.opentube.database.playlist.model.PlaylistStreamEntity
import org.schabi.opentube.database.stream.model.StreamEntity
import org.schabi.opentube.database.stream.model.StreamStateEntity
import org.schabi.opentube.extractor.stream.StreamInfoItem
import org.schabi.opentube.util.image.ImageStrategy

data class PlaylistStreamEntry(
    @Embedded
    val streamEntity: StreamEntity,

    @ColumnInfo(name = StreamStateEntity.STREAM_PROGRESS_MILLIS, defaultValue = "0")
    val progressMillis: Long,

    @ColumnInfo(name = PlaylistStreamEntity.JOIN_STREAM_ID)
    val streamId: Long,

    @ColumnInfo(name = PlaylistStreamEntity.JOIN_INDEX)
    val joinIndex: Int
) : LocalItem {

    override val localItemType: LocalItem.LocalItemType
        get() = LocalItem.LocalItemType.PLAYLIST_STREAM_ITEM

    @Throws(IllegalArgumentException::class)
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
}
