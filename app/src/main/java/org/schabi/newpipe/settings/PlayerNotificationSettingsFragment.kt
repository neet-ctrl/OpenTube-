package org.schabi.opentube.settings

import android.os.Bundle

class PlayerNotificationSettingsFragment : BasePreferenceFragment() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResourceRegistry()
    }
}
