package com.itproger.darova

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(val context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "appdb", factory, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, email TEXT, pass TEXT)"
        val query2 = "CREATE TABLE items (id INT PRIMARY KEY, image TEXT, title TEXT, description TEXT, price TEXT, user_id INT)"
        db!!.execSQL(query)
        db!!.execSQL(query2)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addItem(item: Item) {
        val values = ContentValues()
        values.put("id", item.id)
        values.put("title", item.title)
        values.put("text", item.text)
        values.put("description", item.desc)
        values.put("price", item.price)
        values.put("user_id", item.user_id)


        val db = this.writableDatabase
        db.insert("items", null, values)

        db.close()
    }

    fun addUser(user: User) {
        val values = ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("pass", user.pass)
        

        val db = this.writableDatabase
        db.insert("users", null, values)

        db.close()
    }

    fun getUser(login: String, pass: String): Int {
        val db = this.readableDatabase

        val result =
            db.rawQuery("SELECT * FROM users WHERE login='$login' AND pass = '$pass'", null)
        result.moveToFirst()
        val id = result.getInt(0)
        return id
    }

    fun getItems(user_id: Int?): Cursor? {
        val db = this.writableDatabase
        val result = db.rawQuery("SELECT * FROM items WHERE user_id = $user_id", null)
        return result

    }


}