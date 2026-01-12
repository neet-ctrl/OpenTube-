package org.schabi.opentube.database.stream

import androidx.room.ColumnInfo
import androidx.room.Embedded
import org.schabi.opentube.database.stream.model.StreamEntity
import org.schabi.opentube.database.stream.model.StreamStateEntity

data class StreamWithState(
    @Embedded
    val stream: StreamEntity,

    @ColumnInfo(name = StreamStateEntity.STREAM_PROGRESS_MILLIS)
    val stateProgressMillis: Long?
)
