package org.schabi.opentube.local.holder;

import android.text.TextUtils;
import android.view.ViewGroup;

import org.schabi.opentube.database.LocalItem;
import org.schabi.opentube.database.playlist.model.PlaylistRemoteEntity;
import org.schabi.opentube.local.LocalItemBuilder;
import org.schabi.opentube.local.history.HistoryRecordManager;
import org.schabi.opentube.util.Localization;
import org.schabi.opentube.util.image.PicassoHelper;
import org.schabi.opentube.util.ServiceHelper;

import java.time.format.DateTimeFormatter;

public class RemotePlaylistItemHolder extends PlaylistItemHolder {

    public RemotePlaylistItemHolder(final LocalItemBuilder infoItemBuilder,
                                    final ViewGroup parent) {
        super(infoItemBuilder, parent);
    }

    RemotePlaylistItemHolder(final LocalItemBuilder infoItemBuilder, final int layoutId,
                             final ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
    }

    @Override
    public void updateFromItem(final LocalItem localItem,
                               final HistoryRecordManager historyRecordManager,
                               final DateTimeFormatter dateTimeFormatter) {
        if (!(localItem instanceof PlaylistRemoteEntity)) {
            return;
        }
        final PlaylistRemoteEntity item = (PlaylistRemoteEntity) localItem;

        itemTitleView.setText(item.getOrderingName());
        itemStreamCountView.setText(Localization.localizeStreamCountMini(
                itemStreamCountView.getContext(), item.getStreamCount()));
        // Here is where the uploader name is set in the bookmarked playlists library
        if (!TextUtils.isEmpty(item.getUploader())) {
            itemUploaderView.setText(Localization.concatenateStrings(item.getUploader(),
                    ServiceHelper.getNameOfServiceById(item.getServiceId())));
        } else {
            itemUploaderView.setText(ServiceHelper.getNameOfServiceById(item.getServiceId()));
        }

        PicassoHelper.loadPlaylistThumbnail(item.getThumbnailUrl()).into(itemThumbnailView);

        super.updateFromItem(localItem, historyRecordManager, dateTimeFormatter);
    }
}
