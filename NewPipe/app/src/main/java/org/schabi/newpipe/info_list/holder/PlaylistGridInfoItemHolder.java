package org.schabi.opentube.info_list.holder;

import android.view.ViewGroup;

import org.schabi.opentube.R;
import org.schabi.opentube.info_list.InfoItemBuilder;

public class PlaylistGridInfoItemHolder extends PlaylistMiniInfoItemHolder {
    public PlaylistGridInfoItemHolder(final InfoItemBuilder infoItemBuilder,
                                      final ViewGroup parent) {
        super(infoItemBuilder, R.layout.list_playlist_grid_item, parent);
    }
}
