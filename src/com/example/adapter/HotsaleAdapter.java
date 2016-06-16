package com.example.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bean.Good;
import com.example.myapplication.MyApplication;
import com.example.newapp.MainActivity;
import com.example.newapp.R;
import com.example.utils.MyImagerLoderUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * @作者 陈籽屹
 * @时间 2016年5月29日 商品适配器
 */
public class HotsaleAdapter extends BaseAdapter {

	private List<Good> listdata;
	private Context context;
	private LayoutInflater layoutInflater;
	private ViewHolder holder;
	private String url = "http://192.168.1.102:8080/Vegetable/upload/";

	public HotsaleAdapter(List<Good> listdata, Context context) {
		super();
		this.listdata = listdata;
		this.context = context;
		this.layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return listdata.size() != 0 ? listdata.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO 自动生成的方法存根
		return listdata.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO 自动生成的方法存根
		return position;
	}

	int count = 0;

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO 自动生成的方法存根
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = layoutInflater.inflate(R.layout.hotsale_item, null);
			holder.iv_hotsale_item = (ImageView) convertView
					.findViewById(R.id.iv_hotsale_item);
			holder.iv_hotsale_car = (ImageView) convertView
					.findViewById(R.id.iv_hotsale_car);
			holder.tv_hotsale_name = (TextView) convertView
					.findViewById(R.id.tv_hotsale_name);
			holder.tv_hotsale_price = (TextView) convertView
					.findViewById(R.id.tv_hotsale_price);
		
			convertView.setTag(holder);
		} else {
			convertView.getTag();
		}
		holder.iv_hotsale_car.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				// tv_count.setVisibility(View.VISIBLE);
				// tv_count.setText(++count);
				if (onbuyListener != null) {
					onbuyListener.onBuy();
				}
			}
		});
		holder.tv_hotsale_name.setText(listdata.get(position).getGoodName());
		holder.tv_hotsale_price.setText("￥"
				+ listdata.get(position).getGoodPrice());
		// holder.iv_hotsale_item.setBackgroundResource(R.drawable.dacong);
		final String Url=url+listdata.get(position).getGoodImgPath();
		holder.iv_hotsale_item.setTag(Url);
		ImageLoader.getInstance().displayImage(Url, holder.iv_hotsale_item, MyImagerLoderUtils.option()); /*new SimpleImageLoadingListener(){

			@Override
			public void onLoadingComplete(String imageUri, View view,
					Bitmap loadedImage) {
				// TODO 自动生成的方法存根
				super.onLoadingComplete(imageUri, view, loadedImage);
//			if(imageUri!=null&&imageUri.equals(holder.iv_hotsale_item.getTag())){
//				holder.iv_hotsale_item.setImageBitmap(loadedImage);
//			}
			}
			
			
		});*/
		return convertView;
	}

	class ViewHolder {
		private ImageView iv_hotsale_item;
		private ImageView iv_hotsale_car;
		private TextView tv_hotsale_price;
		private TextView tv_hotsale_name;
	}

	public interface onBuyListener {
		void onBuy();
	}

	onBuyListener onbuyListener;

	public void setOnBuyListener(onBuyListener onbuylistener) {
		this.onbuyListener = onbuylistener;
	}
}
