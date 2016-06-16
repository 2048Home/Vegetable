package com.example.newapp.fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.ShoppingCarAdapter;
import com.example.adapter.ShoppingCarAdapter.onJianListener;
import com.example.api.API;
import com.example.base.BaseFragment;
import com.example.bean.Good;
import com.example.newapp.R;
import com.example.utils.InfoUtils;
import com.example.utils.JsonUtils;

/**
 * @作者 陈籽屹
 * @时间 2016年5月30日 购物车
 */
public class Fragment02 extends BaseFragment implements OnClickListener {
	private View view;
	private ListView shopping_car;
	private List<Good> listdata;
	private ShoppingCarAdapter shoppingCarAdapter;
	TextView tv_totalprice;

	/**
	 * 清空
	 */
	Button btn_clear;
	/**
	 * 下单
	 */
	private Button btn_buy;

	private static Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case InfoUtils.INFO_SUCCESS:

				break;

			case InfoUtils.INFO_ERROR:

				break;
			}

		};
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		view = inflater.inflate(R.layout.shopping_car, null);
		intiView();
		return view;
	}

	int count = 0;

	private void intiView() {
		// TODO 自动生成的方法存根
		listdata = new ArrayList<>();
		Good good = new Good();
		good.setGoodName("花生");
		good.setGoodPrice("2");
		listdata.add(good);
		good = new Good();
		good.setGoodName("黄瓜");
		good.setGoodPrice("3");
		listdata.add(good);
		good = new Good();
		good.setGoodName("西瓜");
		good.setGoodPrice("4");
		listdata.add(good);
		shopping_car = (ListView) view.findViewById(R.id.shopping_car);
		shoppingCarAdapter = new ShoppingCarAdapter(listdata, getActivity());
		tv_totalprice = (TextView) view.findViewById(R.id.tv_totalprice);
		btn_clear = (Button) view.findViewById(R.id.btn_clear);
		btn_clear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				listdata.clear();
				shoppingCarAdapter.notifyDataSetChanged();
				tv_totalprice.setText("");
			}
		});

		shoppingCarAdapter.setonJianListener(new onJianListener() {

			@Override
			public void onJian(int price, String state, int position) {
				// TODO 自动生成的方法存根
				if (state.equals("add")) {
					count += price;
					tv_totalprice.setText(String.valueOf(count));
				} else if (state.equals("jian")) {
					count -= price;
					tv_totalprice.setText(String.valueOf(count));
				} else {
					listdata.remove(position);
					shoppingCarAdapter.notifyDataSetChanged();
				}

			}
		});
		shopping_car.setAdapter(shoppingCarAdapter);
		btn_buy = (Button) view.findViewById(R.id.btn_buy);
		btn_buy.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.btn_buy:
			List<Good> list=new ArrayList<>();
			String url = API.RequestOrder_URL;
			Good good = new Good();
			good.setGoodName("西红柿");
			good.setGoodPrice("21");
			good.setGoodWeight("52");
			list.add(good);
			try {
				String json=JsonUtils.setJsonData(list);
				set_order_info(getActivity(), url, "153641583973","长沙市", json, new Messenger(handler));
			} catch (JSONException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}

}
