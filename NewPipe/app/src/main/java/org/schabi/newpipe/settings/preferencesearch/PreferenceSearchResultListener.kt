/*
 * SPDX-FileCopyrightText: 2022-2026 OpenTube contributors <https://opentube.net>
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package org.schabi.opentube.settings.preferencesearch

interface PreferenceSearchResultListener {
    fun onSearchResultClicked(result: PreferenceSearchItem)
}
