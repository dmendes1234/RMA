package com.example.shoppinglist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterDatabase {

    HelperDatabase helperDatabase;

    public AdapterDatabase(Context context) {
        helperDatabase = new HelperDatabase(context);
    }

    // ******************************************************************************************
    //
    // Database Methods
    //
    // ******************************************************************************************

    public long addItem (String item_name){
        long mId = -1;

        SQLiteDatabase db = helperDatabase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(helperDatabase.ITEM_NAME, item_name);
        mId = db.insert(helperDatabase.TABLE_1_NAME, null, contentValues);
        db.close();
        return mId;
    }

    @Nullable
    public ArrayList<String> getAllItems() {
        ArrayList<String> items;
        int mNumRows, mIndex;
        String item;
        String [] columns = { helperDatabase.ITEM_NAME };
        SQLiteDatabase db = helperDatabase.getWritableDatabase();
        Cursor cursor = db.query(helperDatabase.TABLE_1_NAME, columns, null, null, null, null, null);
        mNumRows = cursor.getCount();
        if (mNumRows < 1)
            return null;
        items = new ArrayList<String>(mNumRows);
        cursor.moveToFirst();
        while(cursor.moveToNext()) {
            mIndex = cursor.getColumnIndex(helperDatabase.ITEM_NAME);
            item = cursor.getString(mIndex);
            items.add(item);
        }
        db.close();
        return items;
    }

    public int deleteItem(String item_name) {
        SQLiteDatabase db = helperDatabase.getWritableDatabase();
        String whereStmt = helperDatabase.ITEM_NAME + " =? ";
        String [] whereArgs = { item_name };
        int mCount = db.delete(
                helperDatabase.TABLE_1_NAME,
                whereStmt,
                whereArgs
        );
        db.close();
        return mCount;
    }

    // ******************************************************************************************
    static class HelperDatabase extends SQLiteOpenHelper{

        Context context;

        private static final String DATABASE_NAME = "items_database";
        private static final int DATABASE_VERSION = 1;

        private static final String TABLE_1_NAME = "items";

        private static final String ID = "_id";
        private static final String ITEM_NAME = "item_name";

        private static final String CREATE_TABLE_1 = "CREATE TABLE " + TABLE_1_NAME + " (" +
                                                             ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                             ITEM_NAME + " VARCHAR(50));";

        public HelperDatabase (Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE_1);
                Message.showMessage(context, "Creating table successful!");
            }
            catch (SQLException exception){
                Message.showMessage(context, "" + exception);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_1_NAME);
            onCreate(db);
        }
    }
}
