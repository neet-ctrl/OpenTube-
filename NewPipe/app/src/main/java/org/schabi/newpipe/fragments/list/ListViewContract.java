package org.schabi.opentube.fragments.list;

import org.schabi.opentube.fragments.ViewContract;

public interface ListViewContract<I, N> extends ViewContract<I> {
    void showListFooter(boolean show);

    void handleNextItems(N result);
}
