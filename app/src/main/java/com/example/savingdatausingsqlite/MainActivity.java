package com.example.savingdatausingsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.savingdatausingsqlite.FeedReaderContract.*;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    FeedReaderDbHelper mDbHelper;
    List itemIds;

    TextView tv_view;

    CRUD crud;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        crud = new CRUD();

        crud.tv_view = (TextView) findViewById(R.id.tv_view);

        mDbHelper = new FeedReaderDbHelper(getApplicationContext());

        crud.insert(context);
        crud.read(context);
    }

    @Override
    protected void onDestroy() {
        crud.closeConnection(context);
        super.onDestroy();
    }
}
