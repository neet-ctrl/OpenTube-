/*
 * SPDX-FileCopyrightText: 2018-2025 OpenTube contributors <https://opentube.net>
 * SPDX-FileCopyrightText: 2025 OpenTube e.V. <https://opentube-ev.de>
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package org.schabi.opentube.database.playlist

import org.schabi.opentube.database.LocalItem

interface PlaylistLocalItem : LocalItem {
    val orderingName: String?
    val displayIndex: Long?
    val uid: Long
    val thumbnailUrl: String?
}
