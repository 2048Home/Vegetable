package com.example.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.example.bean.Good;
import com.example.myapplication.MyApplication;
import com.google.gson.reflect.TypeToken;

public class JsonUtils {
	private static List<Good> listdata;

	public static List<Good> jsonParse(String jsondata) {
		listdata = new ArrayList<Good>();
		try {

			JSONObject json = new JSONObject(jsondata);
			String str = json.getString("goodKind");
			String strrray = json.getString("goodShow");
			JosnOper jp = new JosnOper();
			List<Good> list = jp.ConvertJsonToArray(strrray,
					new TypeToken<List<Good>>() {
					}.getType());
			for (int i = 0; i < list.size(); i++) {

				Good good = new Good();
				good.setGoodName(((Good) list.get(i)).getGoodName());
				good.setGoodPrice(((Good) list.get(i)).getGoodPrice());
				good.setGoodWeight(((Good) list.get(i)).getGoodWeight());
				good.setGoodImgPath(((Good) list.get(i)).getGoodImgPath());
				good.setOnBoxWeight(list.get(i).getOnBoxWeight());
				listdata.add(good);
			}
			return listdata;
		} catch (JSONException e) {
			// TODO 自动生成的 catch 块
			Log.e(MyApplication.TAG, "JSONException=" + e);
			e.printStackTrace();
		}
		return listdata;

	}
	
	/**
	 * 下订单设置JSON数据
	 * @throws JSONException
	 */
	public static String setJsonData(List<Good> list) throws JSONException{
		JSONObject jo=new JSONObject();
		JSONArray ja=new JSONArray();
		for(int i=0;i<list.size();i++){
			JSONObject jsonobj=new JSONObject();
			jsonobj.put("goodName", list.get(i).getGoodName());
			jsonobj.put("goodPrice", list.get(i).getGoodPrice());
			jsonobj.put("goodWeight", list.get(i).getGoodWeight());
//			jsonobj.put("priceKind", "斤");
			ja.put(0, jsonobj);
		}
		jo.put("detailOrder",ja);
		String jsonstr=jo.toString();
		Log.d(MyApplication.TAG, jsonstr);
		return jsonstr;
	}

}
