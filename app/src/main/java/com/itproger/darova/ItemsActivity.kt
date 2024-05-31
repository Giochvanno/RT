package com.itproger.darova

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        val db = DbItem(this, null)
        val bundle: Bundle? = intent.extras
        val user: Int? = bundle?.getInt("user_id")

        val itemsList: RecyclerView = findViewById(R.id.itemslist)
        val items = arrayListOf<Item>()
        val item = Item(1, "thunderobot", "Thunderobot 911 Air XS D", "sdfsdfsdfdsf", "sdfdsf", 499, 0)



//        items.add(Item(1, "thunderobot", "Thunderobot 911 Air XS D", "Thunderobot for relax gameplay.", "Ноутбуки Thunderobot – это мощные устройства, которые подойдут не только геймерам, но и всем, кто нуждается в компактной и производительной технике.", 319))
//        items.add(Item(2, "iphone15", "Apple iPhone 15 5G Black, 128 GB", "Самая совершенная система двух камер на iPhone.", "В iPhone 15 реализованы инновационные передовые функции, в том числе прочная конструкция с панелью из стекла с цветным напылением и фактурным матовым покрытием", 499))


        db.addItem(item)
        val cursor = db.getItems(user)
        if(cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val id: Int = cursor.getInt(0)
                    val  image: String = cursor.getString(1)
                    val  title: String = cursor.getString(2)
                    val  desc: String = cursor.getString(3)
                    val  text: String = cursor.getString(4)
                    val  price: Int = cursor.getInt(5)
                    val  user_id: Int = cursor.getInt(6)
                    items.add(Item(id, image, title, desc, text, price, user_id))
                } while (cursor.moveToNext())
            }
        }
        cursor?.close()
        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}