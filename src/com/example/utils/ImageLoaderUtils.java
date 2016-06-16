package com.example.utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class ImageLoaderUtils extends SimpleImageLoadingListener {
	public static final List<String> displayedImages = Collections
			.synchronizedList(new LinkedList<String>());
         @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
        	// TODO 自动生成的方法存根
        		if (loadedImage != null) {
    				ImageView imageView = (ImageView) view;
    				// boolean isFirstDisplay = !displayedImages.contains(imageUri);
    				// if (isFirstDisplay) {
    				// 图片的淡入效果
    				FadeInBitmapDisplayer.animate(imageView, 500);
    				displayedImages.add(imageUri);
    				// }
    			}
        }	
}
