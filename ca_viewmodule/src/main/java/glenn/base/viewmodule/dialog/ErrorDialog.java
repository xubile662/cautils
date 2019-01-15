package glenn.base.viewmodule.dialog;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import glenn.base.viewmodule.R;
import glenn.base.viewmodule.textView.LazyTextview;

public class ErrorDialog extends LazyDialog {
    private View contentView;
    private LazyTextview ltv_error;
    private Context mContext;
    private String title = "", text = "";

    public ErrorDialog(@NonNull Context context, Activity parent, Boolean isHideToolbar, Boolean hideCloseBtn, String title, String text) {
        super(context, parent, isHideToolbar, hideCloseBtn);
        mContext = context;
        this.text = text;
        this.title = title;
        initComponent();
        initContent();

    }

    private void initComponent() {
        contentView = LayoutInflater.from(getContext()).inflate(R.layout.dialogerr, null);
        this.setContainerView(contentView);
        this.getToolbarView().setBackgroundColor(ContextCompat.getColor(mContext, R.color.ocean_blue));
        this.setToolbarDarkmode();
        Window window = this.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER;
        window.setAttributes(wlp);

        TextView titleTv = this.getToolbarView().findViewById(R.id.title);
        titleTv.setText("");
        ltv_error = contentView.findViewById(R.id.ltv_error);
    }

    private void initContent() {
        ltv_error.setText(text);
        ltv_error.setTitle(title);
    }

}
