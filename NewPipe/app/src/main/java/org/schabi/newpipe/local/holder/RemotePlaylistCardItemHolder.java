package org.schabi.opentube.local.holder;

import android.view.ViewGroup;

import org.schabi.opentube.R;
import org.schabi.opentube.local.LocalItemBuilder;

/**
 * Playlist card UI for list item.
 */
public class RemotePlaylistCardItemHolder extends RemotePlaylistItemHolder {

    public RemotePlaylistCardItemHolder(final LocalItemBuilder infoItemBuilder,
                                        final ViewGroup parent) {
        super(infoItemBuilder, R.layout.list_playlist_card_item, parent);
    }
}
