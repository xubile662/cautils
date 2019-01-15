package glenn.base.viewmodule.spinner;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;

public class CustomSpinner extends android.support.v7.widget.AppCompatSpinner {
    OnItemSelectedListener listener;

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setSelection(int position) {
        super.setSelection(position);
        if (listener != null)
            listener.onItemSelected(null, null, position, 0);
    }

    public void setOnItemSelectedEvenIfUnchangedListener(
            OnItemSelectedListener listener) {
        this.listener = listener;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        try {
            super.onRestoreInstanceState(state);
        } catch (Exception e) {
            super.onRestoreInstanceState(onSaveInstanceState());
        }
    }

}
