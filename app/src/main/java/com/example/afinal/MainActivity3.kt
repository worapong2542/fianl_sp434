package com.example.afinal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


var url2: ArrayList<String> = arrayListOf()
var bookname2: ArrayList<String> = arrayListOf()
var showToast2 = ""
var name2 = ""
var url_img2 = ""
var userid2 = ""
var userid_intent2 = ""


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val Search_Header = findViewById<ImageView>(R.id.Search_Header)
        val Buttom_Grid_1 = findViewById<ImageView>(R.id.Buttom_Grid_1)
        val Buttom_Grid_2 = findViewById<ImageView>(R.id.Buttom_Grid_2)
        val Buttom_Grid_3 = findViewById<ImageView>(R.id.Buttom_Grid_3)
        val Buttom_Grid_4 = findViewById<ImageView>(R.id.Buttom_Grid_4)
        userid_intent2 = intent.extras?.getString("userid").toString()
        Search_Header.setOnClickListener {
            val intent_search = Intent(this@MainActivity3, MainActivity2::class.java)
            startActivity(intent_search)
        }
        Buttom_Grid_1.setOnClickListener {
            val home = Intent(this@MainActivity3, MainActivity::class.java)
            startActivity(home)
        }
        Buttom_Grid_2.setOnClickListener {
            val bookshelf = Intent(this@MainActivity3, MainActivity3::class.java)
            startActivity(bookshelf)
        }
        Buttom_Grid_3.setOnClickListener {
            val fav = Intent(this@MainActivity3, MainActivity2::class.java)
            startActivity(fav)
        }
        Buttom_Grid_4.setOnClickListener {
            val profile = Intent(this@MainActivity3, MainActivity2::class.java)
            startActivity(profile)
        }
        val mFireStore = FirebaseFirestore.getInstance()
        mFireStore.collection("Libray").get()
            .addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                if (task.isSuccessful) {
                    url2.clear()
                    bookname2.clear()
                    for (document in task.result!!) {
                        //if ((document.data).getValue("userid") == "Test") {
                        val book2 = BookList2(userid2, name2, url_img2)
                        book2.name = document.data.getValue("name").toString()
                        book2.url_img = document.data.getValue("url_img").toString()
                        bookname2.add(book2.name)
                        url2.add(book2.url_img)
                        //}
                    }
                    Log.i("name", bookname2.toString())
                    Log.i("url_img", url2.toString())
                    var listView2 = findViewById<ListView>(R.id.listview);
                    val customAdptor = CustomAdptor2(this)
                    listView2.adapter = customAdptor
                    listView2.setOnItemClickListener { parent, view, position, id ->
                        var position_now = position.toInt()
                        showToast2 = bookname2[position_now]
                        Toast.makeText(this, "You Clicked:" + " " + showToast, Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            })
    }
}

class CustomAdptor2(private val context: Activity) : BaseAdapter() {

    override fun getCount(): Int {
        return url2.size
    }

    override fun getItem(position: Int): Any {
        return url2[position]
    }

    override fun getItemId(position: Int): Long {
        return url2[position].toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var inflater2 = context.layoutInflater
        var view2 = inflater2.inflate(R.layout.rowdata2, null)
        val fimage2 = view2.findViewById<ImageView>(R.id.fImage2)
        var fName2 = view2.findViewById<TextView>(R.id.fname2)
        Picasso.get().load(url2[position]).into(fimage2)
        fName2.setText(bookname2[position])
        return view2
    }

}