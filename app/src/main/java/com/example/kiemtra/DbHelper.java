package com.example.kiemtra;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context, "ToDoDatabase", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE TODO(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TITLE TEXT, CONTENT TEXT, DATE TEXT, TYPE TEXT, STATUS INTEGER)";

        sqLiteDatabase.execSQL(sql);

        String data = "INSERT INTO TODO VALUES(1, 'Học java', 'Học java cơ bản', '27/2/2023', 'Bình thường', 1), " +
                "(2, 'Học React Native', 'Học React Native cơ bản', '24/3/2023', 'Khó', 1), " +
                "(3, 'Học Kotlin', 'Học Kotlin cơ bản', '24/3/2023', 'Dễ', 0)," +
                "(4, 'Học Android', 'Học Android cơ bản', '22/12/2023','Khó',1)";

        sqLiteDatabase.execSQL(data);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i != i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS TODO");
            onCreate(sqLiteDatabase);
        }
    }
}
