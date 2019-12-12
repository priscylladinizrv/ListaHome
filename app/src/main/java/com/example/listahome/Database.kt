package com.example.listahome

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class Database(context: Context) : SQLiteOpenHelper(context, "bancoDeDados.db", null, 1) {

    companion object {

        const val TAG = "Database"
        const val TABLE = "Cadastro"
        const val ID: String = "Id"
        const val TITLE: String = "Title"

    }

    val DATABASE_CREATE =
        "CREATE TABLE if not exists " + TABLE + " (" +
                "${ID} integer," +
                "${TITLE} text"+
                ")"

    fun insertLog(text: String) {
        val values = ContentValues()
        values.put(ID, text)
        values.put(TITLE, System.currentTimeMillis())
        writableDatabase.insert(TABLE, null, values);
    }


    fun removeLog(id: Int): Int {
        return writableDatabase.delete(TABLE, "${ID}=${id}", null)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("MyDatabase", "Creating: $DATABASE_CREATE")
        db?.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS" + TABLE);
        onCreate(db);
    }
}