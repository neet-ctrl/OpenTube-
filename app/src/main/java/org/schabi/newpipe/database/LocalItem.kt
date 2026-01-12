/*
 * SPDX-FileCopyrightText: 2018-2020 OpenTube contributors <https://opentube.net>
 * SPDX-FileCopyrightText: 2025 OpenTube e.V. <https://opentube-ev.de>
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package org.schabi.opentube.database

interface LocalItem {
    val localItemType: LocalItemType

    enum class LocalItemType {
        PLAYLIST_LOCAL_ITEM,
        PLAYLIST_REMOTE_ITEM,

        PLAYLIST_STREAM_ITEM,
        STATISTIC_STREAM_ITEM,
    }
}
