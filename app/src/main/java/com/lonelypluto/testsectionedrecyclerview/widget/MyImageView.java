package com.lonelypluto.testsectionedrecyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;

/**
 * @Description: 自定义ImageView 实现宽高相等
 * @author: ZhangYW
 * @time: 2019/1/24 9:13
 */
public class MyImageView extends android.support.v7.widget.AppCompatImageView {

	public MyImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyImageView(Context context) {
		super(context);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
				getDefaultSize(0, heightMeasureSpec));
		int childWidthSize = getMeasuredWidth();

		int childHeightSize = getMeasuredHeight();

		// 高度和宽度一样

		heightMeasureSpec = widthMeasureSpec = MeasureSpec.makeMeasureSpec(
				childWidthSize, MeasureSpec.EXACTLY);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
}
