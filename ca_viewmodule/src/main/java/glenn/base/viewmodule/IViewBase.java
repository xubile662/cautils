package glenn.base.viewmodule;

import android.view.View;

public interface IViewBase {
    String getTextContent();

    View getTitleComponent();

    View getComponent();

    void setTitle(String text);
}
