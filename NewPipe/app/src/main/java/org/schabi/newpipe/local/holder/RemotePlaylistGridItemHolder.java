package org.schabi.opentube.local.holder;

import android.view.ViewGroup;

import org.schabi.opentube.R;
import org.schabi.opentube.local.LocalItemBuilder;

public class RemotePlaylistGridItemHolder extends RemotePlaylistItemHolder {
    public RemotePlaylistGridItemHolder(final LocalItemBuilder infoItemBuilder,
                                        final ViewGroup parent) {
        super(infoItemBuilder, R.layout.list_playlist_grid_item, parent);
    }
}
