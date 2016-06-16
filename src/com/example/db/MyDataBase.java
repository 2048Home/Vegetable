package com.example.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBase extends SQLiteOpenHelper{
   private static final int VERSION=1;
   private static final String DBNAME="/mnt/sdcard/databases/newapp.db";
   
   private static final String CREATE_USER_TABLE="create table User( _id integer primary key autoincrement, " +   
           "name varchar(10), password varchar(10))";//用户表
   private static final String CREATE_GOOD_TABLE="create table Good( _id integer primary key autoincrement, " +   
			"goodName varchar(20), goodPrice varchar(10),goodWeight varchar(10),goodImgPath varchar(100),oneBoxWeight varchar(20))";
   
	public MyDataBase(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DBNAME, factory, VERSION);
		// TODO 自动生成的构造函数存根
	}
	public MyDataBase(Context context){
		super(context,DBNAME,null,VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自动生成的方法存根
		db.execSQL(CREATE_USER_TABLE);//创建用户表
		db.execSQL(CREATE_GOOD_TABLE);//创建商品表
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自动生成的方法存根
		
	}

}
