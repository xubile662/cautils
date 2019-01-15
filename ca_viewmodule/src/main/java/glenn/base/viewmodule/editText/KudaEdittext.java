package glenn.base.viewmodule.editText;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import glenn.base.viewmodule.R;

public class KudaEdittext extends LazyEdittext {
    private ImageView kudaImgv;
    private Context mContext;

    public KudaEdittext(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initAdditionalComponent();
    }

    private void initAdditionalComponent() {
        kudaImgv = findViewById(R.id.imgv);
    }

    public void addLogo(String Uri) {
        Glide.with(mContext).load(Uri).into(kudaImgv);
    }

    public void addLogo(int resid) {
        Glide.with(mContext).load(resid).into(kudaImgv);
    }

}
