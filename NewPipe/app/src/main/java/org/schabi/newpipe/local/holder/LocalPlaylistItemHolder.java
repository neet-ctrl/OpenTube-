package org.schabi.opentube.local.holder;

import android.view.View;
import android.view.ViewGroup;

import org.schabi.opentube.database.LocalItem;
import org.schabi.opentube.database.playlist.PlaylistDuplicatesEntry;
import org.schabi.opentube.database.playlist.PlaylistMetadataEntry;
import org.schabi.opentube.local.LocalItemBuilder;
import org.schabi.opentube.local.history.HistoryRecordManager;
import org.schabi.opentube.util.image.PicassoHelper;
import org.schabi.opentube.util.Localization;

import java.time.format.DateTimeFormatter;

public class LocalPlaylistItemHolder extends PlaylistItemHolder {

    private static final float GRAYED_OUT_ALPHA = 0.6f;

    public LocalPlaylistItemHolder(final LocalItemBuilder infoItemBuilder, final ViewGroup parent) {
        super(infoItemBuilder, parent);
    }

    LocalPlaylistItemHolder(final LocalItemBuilder infoItemBuilder, final int layoutId,
                            final ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
    }

    @Override
    public void updateFromItem(final LocalItem localItem,
                               final HistoryRecordManager historyRecordManager,
                               final DateTimeFormatter dateTimeFormatter) {
        if (!(localItem instanceof PlaylistMetadataEntry)) {
            return;
        }
        final PlaylistMetadataEntry item = (PlaylistMetadataEntry) localItem;

        itemTitleView.setText(item.getOrderingName());
        itemStreamCountView.setText(Localization.localizeStreamCountMini(
                itemStreamCountView.getContext(), item.getStreamCount()));
        itemUploaderView.setVisibility(View.INVISIBLE);

        PicassoHelper.loadPlaylistThumbnail(item.getThumbnailUrl()).into(itemThumbnailView);

        if (item instanceof PlaylistDuplicatesEntry
                && ((PlaylistDuplicatesEntry) item).getTimesStreamIsContained() > 0) {
            itemView.setAlpha(GRAYED_OUT_ALPHA);
        } else {
            itemView.setAlpha(1.0f);
        }

        super.updateFromItem(localItem, historyRecordManager, dateTimeFormatter);
    }
}
