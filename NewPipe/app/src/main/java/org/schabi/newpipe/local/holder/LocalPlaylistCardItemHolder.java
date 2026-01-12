package org.schabi.opentube.local.holder;

import android.view.ViewGroup;

import org.schabi.opentube.R;
import org.schabi.opentube.local.LocalItemBuilder;

/**
 * Playlist card layout.
 */
public class LocalPlaylistCardItemHolder extends LocalPlaylistItemHolder {

    public LocalPlaylistCardItemHolder(final LocalItemBuilder infoItemBuilder,
                                       final ViewGroup parent) {
        super(infoItemBuilder, R.layout.list_playlist_card_item, parent);
    }
}
