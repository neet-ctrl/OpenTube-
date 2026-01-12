package org.schabi.opentube.fragments.list.playlist;

import org.schabi.opentube.player.playqueue.PlayQueue;

/**
 * Interface for {@code R.layout.playlist_control} view holders
 * to give access to the play queue.
 */
public interface PlaylistControlViewHolder {
    PlayQueue getPlayQueue();
}
