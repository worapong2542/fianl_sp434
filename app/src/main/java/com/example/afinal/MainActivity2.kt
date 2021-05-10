package com.example.afinal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import android.widget.*
import androidx.lifecycle.Transformations.map
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.squareup.picasso.Picasso



var url: ArrayList<String> = arrayListOf()
var bookname: ArrayList<String> = arrayListOf()
var showToast = ""
var name = ""
var url_img = ""
var userid = ""
var userid_intent = ""


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        userid_intent = intent.extras?.getString("userid").toString()
        val Search_Header = findViewById<ImageView>(R.id.Search_Header)
        val Buttom_Grid_1 = findViewById<ImageView>(R.id.Buttom_Grid_1)
        val Buttom_Grid_2 = findViewById<ImageView>(R.id.Buttom_Grid_2)
        val Buttom_Grid_3 = findViewById<ImageView>(R.id.Buttom_Grid_3)
        val Buttom_Grid_4 = findViewById<ImageView>(R.id.Buttom_Grid_4)
        Search_Header.setOnClickListener {
            val intent_search = Intent(this@MainActivity2, MainActivity2::class.java)
            startActivity(intent_search)
        }
        Buttom_Grid_1.setOnClickListener {
            val home = Intent(this@MainActivity2, MainActivity::class.java)
            startActivity(home)
        }
        Buttom_Grid_2.setOnClickListener {
            val bookshelf = Intent(this@MainActivity2, MainActivity3::class.java)
            startActivity(bookshelf)
        }
        Buttom_Grid_3.setOnClickListener {
            val fav = Intent(this@MainActivity2, MainActivity2::class.java)
            startActivity(fav)
        }
        Buttom_Grid_4.setOnClickListener {
            val profile = Intent(this@MainActivity2, MainActivity2::class.java)
            startActivity(profile)
        }

        val mFireStore = FirebaseFirestore.getInstance()
        mFireStore.collection("Fav").get()
            .addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                if (task.isSuccessful) {
                    url.clear()
                    bookname.clear()
                    for (document in task.result!!) {
                        if ((document.data).getValue("userid") == "Test") {
                            val book = BookList(userid, name, url_img)
                            book.name = document.data.getValue("name").toString()
                            book.url_img = document.data.getValue("url_img").toString()
                            bookname.add(book.name)
                            url.add(book.url_img)
                        }
                    }
                    Log.i("name", bookname.toString())
                    Log.i("url_img", url.toString())
                    var listView = findViewById<ListView>(R.id.listview);
                    val customAdptor = CustomAdptor(this)
                    listView.adapter = customAdptor
                    listView.setOnItemClickListener { parent, view, position, id ->
                        var position_now = position.toInt()
                        showToast = bookname[position_now]
                        Toast.makeText(this, "You Clicked:" + " " + showToast, Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            })
    }
}

class CustomAdptor(private val context: Activity) : BaseAdapter() {

    override fun getCount(): Int {
        return url.size
    }

    override fun getItem(position: Int): Any {
        return url[position]
    }

    override fun getItemId(position: Int): Long {
        return url[position].toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var inflater = context.layoutInflater
        var view1 = inflater.inflate(R.layout.rowdata, null)
        val fimage = view1.findViewById<ImageView>(R.id.fImage)
        var fName = view1.findViewById<TextView>(R.id.fname)
        Picasso.get().load(url[position]).into(fimage)
        fName.setText(bookname[position])
        return view1
    }

}