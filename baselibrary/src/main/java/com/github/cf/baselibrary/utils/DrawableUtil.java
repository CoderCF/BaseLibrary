package com.github.cf.baselibrary.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

public class DrawableUtil {

	/**
	 * 创建圆角矩形 获取一个shape对象
	 *
	 * @param rgb
	 *            颜色值
	 * @param radius
	 *            圆角半径
	 * @return
	 */
	public static Drawable getGradientDrawable(int rgb, int radius) {
		// 初始化对象  xml中定义的shape标签 对应此类
		GradientDrawable shape = new GradientDrawable();
		// 矩形类型
		shape.setShape(GradientDrawable.RECTANGLE);
		//shape.setGradientType(GradientDrawable.RECTANGLE);
		// 设置颜色
		shape.setColor(rgb);
		// 设置圆角半径
		shape.setCornerRadius(radius);
		return shape;
	}

	/**
	 * 动态创建渐变色
	 *
	 * @param rgbs
	 *            颜色值
	 * @return
	 */
	public static Drawable getGradientDrawable(int[] rgbs) {
		// 初始化对象  xml中定义的shape标签 对应此类
		GradientDrawable shape = new GradientDrawable();
		// 类型
		shape.setGradientType(GradientDrawable.LINEAR_GRADIENT);
		// 设置颜色
		shape.setColors(rgbs);

		return shape;
	}

	/**
	 * 返回状态选择器对象(selector)
	 *
	 * @param normal
	 *            默认图像
	 * @param pressed
	 *            按下图像
	 */
	public static Drawable getSelector(Drawable normal, Drawable pressed) {
		StateListDrawable drawable = new StateListDrawable();
		drawable.addState(new int[] { android.R.attr.state_pressed }, pressed);
		drawable.addState(new int[] {}, normal);
		return drawable;
	}

	/**
	 * 返回状态选择器对象(selector)
	 *
	 * @param normalColor
	 *            默认颜色
	 * @param pressedColor
	 *            按下颜色
	 * @param radius
	 *            圆角半径
	 * @return
	 */
	public static Drawable getSelector(int normalColor, int pressedColor, int radius) {
		Drawable normal = getGradientDrawable(normalColor, radius);
		Drawable pressed = getGradientDrawable(pressedColor, radius);
		return getSelector(normal, pressed);
	}


}
