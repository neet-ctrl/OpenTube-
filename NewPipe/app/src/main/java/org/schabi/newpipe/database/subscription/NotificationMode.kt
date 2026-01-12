/*
 * SPDX-FileCopyrightText: 2021 OpenTube contributors <https://opentube.net>
 * SPDX-FileCopyrightText: 2025 OpenTube e.V. <https://opentube-ev.de>
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package org.schabi.opentube.database.subscription

import androidx.annotation.IntDef

@IntDef(NotificationMode.Companion.DISABLED, NotificationMode.Companion.ENABLED)
@Retention(AnnotationRetention.SOURCE)
annotation class NotificationMode {
    companion object {
        const val DISABLED = 0
        const val ENABLED = 1 // other values reserved for the future
    }
}
