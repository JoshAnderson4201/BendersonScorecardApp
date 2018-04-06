package com.example.ja160637.bendersonscorecard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by retre on 4/5/2018.
 */



public class DatabaseHandler extends SQLiteOpenHelper
{
    public DatabaseHandler(Context context)
    {
        super(context, "rounds", null, 1);
    }

    public void onCreate(SQLiteDatabase db)
    {
        String sqlCreate = "create table rounds ( id integer primary key autoincrement";
        for (int i = 0; i < 18; i++)
        {
            sqlCreate = sqlCreate + ", hole" + (i+1) + " text";
        }
        sqlCreate = sqlCreate + " )";
        Log.i("SQL Create", sqlCreate);
        db.execSQL(sqlCreate);
    }

    public void onUpgrade( SQLiteDatabase db,
                           int oldVersion, int newVersion ) {
        // Drop old table if it exists
        db.execSQL( "drop table if exists holes" );
        // Re-create tables
        onCreate( db );
    }

    public void insertRound( String[] roundArray)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "insert into rounds values (null, '";
        for(int i = 0; i < roundArray.length; i++)
        {
            if(i != 17)
            {
                sqlInsert = sqlInsert + roundArray[i] + "', '";
            }
            else
                sqlInsert = sqlInsert + roundArray[i] + "' )";
        }
        Log.i("Insert Query", sqlInsert);
        db.execSQL( sqlInsert );
    }
}
