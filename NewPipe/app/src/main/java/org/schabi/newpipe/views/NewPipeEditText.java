package org.schabi.opentube.views;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import org.schabi.opentube.util.OpenTubeTextViewHelper;
import org.schabi.opentube.util.external_communication.ShareUtils;

/**
 * An {@link AppCompatEditText} which uses {@link ShareUtils#shareText(Context, String, String)}
 * when sharing selected text by using the {@code Share} command of the floating actions.
 *
 * <p>
 * This class allows OpenTube to show Android share sheet instead of EMUI share sheet when sharing
 * text from {@link AppCompatEditText} on EMUI devices.
 * </p>
 */
public class OpenTubeEditText extends AppCompatEditText {

    public OpenTubeEditText(@NonNull final Context context) {
        super(context);
    }

    public OpenTubeEditText(@NonNull final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);
    }

    public OpenTubeEditText(@NonNull final Context context,
                           @Nullable final AttributeSet attrs,
                           final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTextContextMenuItem(final int id) {
        if (id == android.R.id.shareText) {
            OpenTubeTextViewHelper.shareSelectedTextWithShareUtils(this);
            return true;
        }
        return super.onTextContextMenuItem(id);
    }
}
