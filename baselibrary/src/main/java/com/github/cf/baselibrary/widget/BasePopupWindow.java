package com.github.cf.baselibrary.widget;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;

/**
 * PopupWindow基类
 */
public abstract class BasePopupWindow extends PopupWindow{

    @Override
    public void setContentView(View contentView) {

        // 设置PopupWindow弹出窗体的宽
        this.setWidth(ActionBar.LayoutParams.MATCH_PARENT);
        // 设置PopupWindow弹出窗体的高
        this.setHeight(ActionBar.LayoutParams.MATCH_PARENT);
        // 设置PopupWindow弹出窗体可点击
        this.setFocusable(true);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(Color.BLACK);
        dw.setAlpha(120);
        //设置PopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);

        super.setContentView(contentView);
    }

    //重写显示位置方法 兼容7.0之后的显示问题。
    @Override
    public void showAsDropDown(View anchor) {
        if( Build.VERSION_CODES.M < Build.VERSION.SDK_INT){
            Rect rect = new Rect();
            anchor.getGlobalVisibleRect(rect);
            int h = anchor.getResources().getDisplayMetrics().heightPixels - rect.bottom;
            setHeight(h);
        }
        super.showAsDropDown(anchor);
    }

}
