package com.example.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.bean.Good;
import com.example.db.MyDataBase;

public class UserDao {
	private MyDataBase helper;
	private SQLiteDatabase db;

	public UserDao(Context context) {
		helper = new MyDataBase(context);
	}

	public void add(Good good) {
		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
		// 执行添加信息操作
		db.execSQL("insert into Good (_id,goodName,goodPrice,goodWeight,goodImgPath,oneBoxWeight) values (?,?,?,?,?)");
	}
}
