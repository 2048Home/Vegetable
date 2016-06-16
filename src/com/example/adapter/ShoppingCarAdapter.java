package com.example.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bean.Good;
import com.example.newapp.R;

/**
 * @作者 陈籽屹
 * @时间 2016年5月29日 购物车
 */
public class ShoppingCarAdapter extends BaseAdapter {
	private List<Good> listdata;
	private Context context;
	private LayoutInflater layoutInflater;
	private ViewHolder holder;

	public ShoppingCarAdapter(List<Good> listdata, Context context) {
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
	@Override
	public View getView( int position, View convertView, ViewGroup parent) {
		// TODO 自动生成的方法存根
		final String price = listdata.get(position).getGoodPrice();
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = layoutInflater.inflate(R.layout.shopping_car_item,
					null);
			holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
			holder.tv_single_price = (TextView) convertView
					.findViewById(R.id.tv_single_price);
			holder.tv_jian = (TextView) convertView.findViewById(R.id.tv_jian);
			holder.tv_show = (TextView) convertView.findViewById(R.id.tv_show);
			holder.tv_jia = (TextView) convertView.findViewById(R.id.tv_jia);
			holder.iv_picture_name = (ImageView) convertView
					.findViewById(R.id.iv_picture_name);
			holder.iv_remove = (ImageView) convertView
					.findViewById(R.id.iv_remove);
			holder.iv_remove.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					if (onJianListener != null) {
						onJianListener.onJian(Integer.parseInt(price), "remove",0);
					}
					
				}
			});
			holder.tv_jia.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
			
					if (onJianListener != null) {
						onJianListener.onJian(Integer.parseInt(price), "add",0);
						holder.tv_show.setText(++count+"");
					}
				}
			});
			holder.tv_jian.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					if (onJianListener != null) {
						onJianListener.onJian(Integer.parseInt(price), "jian",0);
						if(count>0){
							holder.tv_show.setText(--count+"");
						}
					}
				}
			});
			convertView.setTag(holder);
		} else {
			convertView.getTag();
		}

	

		

		holder.tv_name.setText(listdata.get(position).getGoodName());
		holder.tv_single_price.setText(price);

		return convertView;
	}
int count=0;
	class ViewHolder {
		private TextView tv_name;
		private TextView tv_single_price;
		private TextView tv_jian;
		private TextView tv_show;
		private TextView tv_jia;
		private ImageView iv_picture_name;
		private ImageView iv_remove;
	}

	// @Override
	// public void onClick(View v) {
	// // TODO 自动生成的方法存根
	// switch (v.getId()) {
	// case R.id.tv_jian:
	// if (onJianListener != null) {
	// onJianListener.onJian(Integer.parseInt(price), "jian");
	// }
	// break;
	// case R.id.tv_jia:
	// if (onJianListener != null) {
	// onJianListener.onJian(Integer.parseInt(price), "add");
	// }
	// break;
	// case R.id.iv_remove:
	// if (onJianListener != null) {
	// onJianListener.onJian(Integer.parseInt(price), "delete");
	// }
	// break;
	// default:
	// break;
	// }
	// }

	public interface onJianListener {
		void onJian(int price, String state,int position);
	}

	onJianListener onJianListener;

	public void setonJianListener(onJianListener onJianListener) {
		this.onJianListener = onJianListener;
	}
}
