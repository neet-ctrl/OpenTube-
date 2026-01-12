package org.schabi.opentube.info_list.holder;

import android.view.ViewGroup;

import org.schabi.opentube.R;
import org.schabi.opentube.info_list.InfoItemBuilder;

public class StreamGridInfoItemHolder extends StreamInfoItemHolder {
    public StreamGridInfoItemHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        super(infoItemBuilder, R.layout.list_stream_grid_item, parent);
    }
}
