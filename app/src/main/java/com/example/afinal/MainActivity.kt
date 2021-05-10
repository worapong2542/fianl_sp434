package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Headcontent
        val Horizontal_img1 = findViewById<ImageView>(R.id.Horizontal_img1)
        val Horizontal_Namebook1 = findViewById<TextView>(R.id.Horizontal_Namebook1)
        val Horizontal_Price1 = findViewById<TextView>(R.id.Horizontal_Price1)
        val Horizontal_urlimg1 = findViewById<TextView>(R.id.Horizontal_urlimg1)
        val Horizontal_img2 = findViewById<ImageView>(R.id.Horizontal_img2)
        val Horizontal_Namebook2 = findViewById<TextView>(R.id.Horizontal_Namebook2)
        val Horizontal_Price2 = findViewById<TextView>(R.id.Horizontal_Price2)
        val Horizontal_urlimg2 = findViewById<TextView>(R.id.Horizontal_urlimg2)
        val Horizontal_img3 = findViewById<ImageView>(R.id.Horizontal_img3)
        val Horizontal_Namebook3 = findViewById<TextView>(R.id.Horizontal_Namebook3)
        val Horizontal_Price3 = findViewById<TextView>(R.id.Horizontal_Price3)
        val Horizontal_urlimg3 = findViewById<TextView>(R.id.Horizontal_urlimg3)
        val Horizontal_img4 = findViewById<ImageView>(R.id.Horizontal_img4)
        val Horizontal_Namebook4 = findViewById<TextView>(R.id.Horizontal_Namebook4)
        val Horizontal_Price4 = findViewById<TextView>(R.id.Horizontal_Price4)
        val Horizontal_urlimg4 = findViewById<TextView>(R.id.Horizontal_urlimg4)
        val Horizontal_img5 = findViewById<ImageView>(R.id.Horizontal_img5)
        val Horizontal_Namebook5 = findViewById<TextView>(R.id.Horizontal_Namebook5)
        val Horizontal_Price5 = findViewById<TextView>(R.id.Horizontal_Price5)
        val Horizontal_urlimg5 = findViewById<TextView>(R.id.Horizontal_urlimg5)
//      content1
        val FCL_Linear_1_img = findViewById<ImageView>(R.id.FCL_Linear_1_img)
        val FCL_Linear_1_Namebook = findViewById<TextView>(R.id.FCL_Linear_1_Namebook)
        val FCL_Linear_1_Price = findViewById<TextView>(R.id.FCL_Linear_1_Price)
        val FCL_Linear_1_urlimg = findViewById<TextView>(R.id.FCL_Linear_1_urlimg)
        val FCL_Linear_2_img = findViewById<ImageView>(R.id.FCL_Linear_2_img)
        val FCL_Linear_2_Namebook = findViewById<TextView>(R.id.FCL_Linear_2_Namebook)
        val FCL_Linear_2_Price = findViewById<TextView>(R.id.FCL_Linear_2_Price)
        val FCL_Linear_2_urlimg = findViewById<TextView>(R.id.FCL_Linear_2_urlimg)
        val FCL_Linear_3_img = findViewById<ImageView>(R.id.FCL_Linear_3_img)
        val FCL_Linear_3_Namebook = findViewById<TextView>(R.id.FCL_Linear_3_Namebook)
        val FCL_Linear_3_Price = findViewById<TextView>(R.id.FCL_Linear_3_Price)
        val FCL_Linear_3_urlimg = findViewById<TextView>(R.id.FCL_Linear_3_urlimg)
        //  content2
        val SCL_Linear_1_img = findViewById<ImageView>(R.id.SCL_Linear_1_img)
        val SCL_Linear_1_Namebook = findViewById<TextView>(R.id.SCL_Linear_1_Namebook)
        val SCL_Linear_1_Price = findViewById<TextView>(R.id.SCL_Linear_1_Price)
        val SCL_Linear_1_urlimg = findViewById<TextView>(R.id.SCL_Linear_1_urlimg)
        val SCL_Linear_2_img = findViewById<ImageView>(R.id.SCL_Linear_2_img)
        val SCL_Linear_2_Namebook = findViewById<TextView>(R.id.SCL_Linear_2_Namebook)
        val SCL_Linear_2_Price = findViewById<TextView>(R.id.SCL_Linear_2_Price)
        val SCL_Linear_2_urlimg = findViewById<TextView>(R.id.SCL_Linear_2_urlimg)
        val SCL_Linear_3_img = findViewById<ImageView>(R.id.SCL_Linear_3_img)
        val SCL_Linear_3_Namebook = findViewById<TextView>(R.id.SCL_Linear_3_Namebook)
        val SCL_Linear_3_Price = findViewById<TextView>(R.id.SCL_Linear_3_Price)
        val SCL_Linear_3_urlimg = findViewById<TextView>(R.id.SCL_Linear_3_urlimg)
        //content3
        val TCL_Linear_1_img = findViewById<ImageView>(R.id.TCL_Linear_1_img)
        val TCL_Linear_1_Namebook = findViewById<TextView>(R.id.TCL_Linear_1_Namebook)
        val TCL_Linear_1_Price = findViewById<TextView>(R.id.TCL_Linear_1_Price)
        val TCL_Linear_1_urlimg = findViewById<TextView>(R.id.TCL_Linear_1_urlimg)
        val TCL_Linear_2_img = findViewById<ImageView>(R.id.TCL_Linear_2_img)
        val TCL_Linear_2_Namebook = findViewById<TextView>(R.id.TCL_Linear_2_Namebook)
        val TCL_Linear_2_Price = findViewById<TextView>(R.id.TCL_Linear_2_Price)
        val TCL_Linear_2_urlimg = findViewById<TextView>(R.id.TCL_Linear_2_urlimg)
        val TCL_Linear_3_img = findViewById<ImageView>(R.id.TCL_Linear_3_img)
        val TCL_Linear_3_Namebook = findViewById<TextView>(R.id.TCL_Linear_3_Namebook)
        val TCL_Linear_3_Price = findViewById<TextView>(R.id.TCL_Linear_3_Price)
        val TCL_Linear_3_urlimg = findViewById<TextView>(R.id.TCL_Linear_3_urlimg)

        //intentdata
        val intentdata = Intent(this@MainActivity, MainActivity2::class.java)
        //listener
//        val Horizontal_Linear_img1 = findViewById<LinearLayout>(R.id.Horizontal_Linear_img1)
//        val Horizontal_Linear_img2 = findViewById<LinearLayout>(R.id.Horizontal_Linear_img2)
//        val Horizontal_Linear_img3 = findViewById<LinearLayout>(R.id.Horizontal_Linear_img3)
//        val Horizontal_Linear_img4 = findViewById<LinearLayout>(R.id.Horizontal_Linear_img4)
//        val Horizontal_Linear_img5 = findViewById<LinearLayout>(R.id.Horizontal_Linear_img5)
//        val FCL_Linear_1 = findViewById<LinearLayout>(R.id.FCL_Linear_1)
//        val FCL_Linear_2 = findViewById<LinearLayout>(R.id.FCL_Linear_2)
//        val FCL_Linear_3 = findViewById<LinearLayout>(R.id.FCL_Linear_3)
//        val SCL_Linear_1 = findViewById<LinearLayout>(R.id.SCL_Linear_1)
//        val SCL_Linear_2 = findViewById<LinearLayout>(R.id.SCL_Linear_2)
//        val SCL_Linear_3 = findViewById<LinearLayout>(R.id.SCL_Linear_3)
//        val TCL_Linear_1 = findViewById<LinearLayout>(R.id.TCL_Linear_1)
//        val TCL_Linear_2 = findViewById<LinearLayout>(R.id.TCL_Linear_2)
//        val TCL_Linear_3 = findViewById<LinearLayout>(R.id.TCL_Linear_3)
        Horizontal_img1.setOnClickListener {
            intentdata.putExtra("namebook", Horizontal_Namebook1.text.toString())
            startActivity(intentdata)
        }
        Horizontal_img2.setOnClickListener {
            intentdata.putExtra("namebook", Horizontal_Namebook2.text.toString())
            startActivity(intentdata)
        }
        Horizontal_img3.setOnClickListener {
            intentdata.putExtra("namebook", Horizontal_Namebook3.text.toString())
            startActivity(intentdata)
        }
        Horizontal_img4.setOnClickListener {
            intentdata.putExtra("namebook", Horizontal_Namebook4.text.toString())
            startActivity(intentdata)
        }
        Horizontal_img5.setOnClickListener {
            intentdata.putExtra("namebook", Horizontal_Namebook5.text.toString())
            startActivity(intentdata)
        }
        FCL_Linear_1_img.setOnClickListener {
            intentdata.putExtra("namebook", FCL_Linear_1_Namebook.text.toString())
            startActivity(intentdata)
        }
        FCL_Linear_2_img.setOnClickListener {
            intentdata.putExtra("namebook", FCL_Linear_2_Namebook.text.toString())
            startActivity(intentdata)
        }
        FCL_Linear_3_img.setOnClickListener {
            intentdata.putExtra("namebook", FCL_Linear_3_Namebook.text.toString())
            startActivity(intentdata)
        }
        SCL_Linear_1_img.setOnClickListener {
            intentdata.putExtra("namebook", SCL_Linear_1_Namebook.text.toString())
            startActivity(intentdata)
        }
        SCL_Linear_2_img.setOnClickListener {
            intentdata.putExtra("namebook", SCL_Linear_2_Namebook.text.toString())
            startActivity(intentdata)
        }
        SCL_Linear_3_img.setOnClickListener {
            intentdata.putExtra("namebook", SCL_Linear_3_Namebook.text.toString())
            startActivity(intentdata)
        }
        TCL_Linear_1_img.setOnClickListener {
            intentdata.putExtra("namebook", TCL_Linear_1_Namebook.text.toString())
            startActivity(intentdata)
        }
        TCL_Linear_2_img.setOnClickListener {
            intentdata.putExtra("namebook", TCL_Linear_2_Namebook.text.toString())
            startActivity(intentdata)
        }
        TCL_Linear_3_img.setOnClickListener {
            intentdata.putExtra("namebook", TCL_Linear_3_Namebook.text.toString())
            startActivity(intentdata)
        }

        //fav listen
        val Horizontal_Imgfav1 = findViewById<ImageView>(R.id.Horizontal_Imgfav1)
        val Horizontal_Imgfav2 = findViewById<ImageView>(R.id.Horizontal_Imgfav2)
        val Horizontal_Imgfav3 = findViewById<ImageView>(R.id.Horizontal_Imgfav3)
        val Horizontal_Imgfav4 = findViewById<ImageView>(R.id.Horizontal_Imgfav4)
        val Horizontal_Imgfav5 = findViewById<ImageView>(R.id.Horizontal_Imgfav5)
        val FCL_Linear_1_Imgfav = findViewById<ImageView>(R.id.FCL_Linear_1_Imgfav)
        val FCL_Linear_2_Imgfav = findViewById<ImageView>(R.id.FCL_Linear_2_Imgfav)
        val FCL_Linear_3_Imgfav = findViewById<ImageView>(R.id.FCL_Linear_3_Imgfav)
        val SCL_Linear_1_Imgfav = findViewById<ImageView>(R.id.SCL_Linear_1_Imgfav)
        val SCL_Linear_2_Imgfav = findViewById<ImageView>(R.id.SCL_Linear_2_Imgfav)
        val SCL_Linear_3_Imgfav = findViewById<ImageView>(R.id.SCL_Linear_3_Imgfav)
        val TCL_Linear_1_Imgfav = findViewById<ImageView>(R.id.TCL_Linear_1_Imgfav)
        val TCL_Linear_2_Imgfav = findViewById<ImageView>(R.id.TCL_Linear_2_Imgfav)
        val TCL_Linear_3_Imgfav = findViewById<ImageView>(R.id.TCL_Linear_3_Imgfav)
        val user = "Test"
        Horizontal_Imgfav1.setOnClickListener {
            add_fav(user.toString(),Horizontal_Namebook1.text.toString(), Horizontal_urlimg1.text.toString())
        }
        Horizontal_Imgfav2.setOnClickListener {
            add_fav(user.toString(),Horizontal_Namebook2.text.toString(), Horizontal_urlimg2.text.toString())
        }
        Horizontal_Imgfav3.setOnClickListener {
            add_fav(user.toString(),Horizontal_Namebook3.text.toString(), Horizontal_urlimg3.text.toString())
        }
        Horizontal_Imgfav4.setOnClickListener {
            add_fav(user.toString(),Horizontal_Namebook4.text.toString(), Horizontal_urlimg4.text.toString())
        }
        Horizontal_Imgfav5.setOnClickListener {
            add_fav(user.toString(),Horizontal_Namebook5.text.toString(), Horizontal_urlimg5.text.toString())
        }
        FCL_Linear_1_Imgfav.setOnClickListener {
            add_fav(user.toString(),FCL_Linear_1_Namebook.text.toString(), FCL_Linear_1_urlimg.text.toString())
        }
        FCL_Linear_2_Imgfav.setOnClickListener {
            add_fav(user.toString(),FCL_Linear_2_Namebook.text.toString(), FCL_Linear_2_urlimg.text.toString())
        }
        FCL_Linear_3_Imgfav.setOnClickListener {
            add_fav(user.toString(),FCL_Linear_3_Namebook.text.toString(), FCL_Linear_3_urlimg.text.toString())
        }
        SCL_Linear_1_Imgfav.setOnClickListener {
            add_fav(user.toString(),SCL_Linear_1_Namebook.text.toString(), SCL_Linear_1_urlimg.text.toString())
        }
        SCL_Linear_2_Imgfav.setOnClickListener {
            add_fav(user.toString(),SCL_Linear_2_Namebook.text.toString(), SCL_Linear_2_urlimg.text.toString())
        }
        SCL_Linear_3_Imgfav.setOnClickListener {
            add_fav(user.toString(),SCL_Linear_3_Namebook.text.toString(), SCL_Linear_3_urlimg.text.toString())
        }
        TCL_Linear_1_Imgfav.setOnClickListener {
            add_fav(user.toString(),TCL_Linear_1_Namebook.text.toString(), TCL_Linear_1_urlimg.text.toString())
        }
        TCL_Linear_2_Imgfav.setOnClickListener {
            add_fav(user.toString(),TCL_Linear_2_Namebook.text.toString(), TCL_Linear_2_urlimg.text.toString())
        }
        TCL_Linear_3_Imgfav.setOnClickListener {
            add_fav(user.toString(),TCL_Linear_3_Namebook.text.toString(), TCL_Linear_3_urlimg.text.toString())
        }

        //intent Botton
        val Search_Header = findViewById<ImageView>(R.id.Search_Header)
        val Buttom_Grid_1 = findViewById<ImageView>(R.id.Buttom_Grid_1)
        val Buttom_Grid_2 = findViewById<ImageView>(R.id.Buttom_Grid_2)
        val Buttom_Grid_3 = findViewById<ImageView>(R.id.Buttom_Grid_3)
        val Buttom_Grid_4 = findViewById<ImageView>(R.id.Buttom_Grid_4)
        Search_Header.setOnClickListener {
            val intent_search = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent_search)
        }
        Buttom_Grid_1.setOnClickListener {
            val home = Intent(this@MainActivity, MainActivity::class.java)
            startActivity(home)
        }
        Buttom_Grid_2.setOnClickListener {
            val bookshelf = Intent(this@MainActivity, MainActivity3::class.java)
            startActivity(bookshelf)
        }
        Buttom_Grid_3.setOnClickListener {
            val fav = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(fav)
        }
        Buttom_Grid_4.setOnClickListener {
            val profile = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(profile)
        }

        //connecting firebase
        val mFireStore = FirebaseFirestore.getInstance()
        mFireStore.collection("Libray").get()
            .addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        if ((document.data).getValue("name") == "MushokuTensei1") {
                            Horizontal_Namebook1.setText(
                                document.data.getValue("name").toString()
                            )
                            Horizontal_Price1.setText(
                                document.data.getValue("price").toString()
                            )
                            Picasso.get().load(document.data.getValue("url_img").toString())
                                .into(Horizontal_img1)
                            Horizontal_urlimg1.setText(
                                document.data.getValue("url_img").toString()
                            )
                        } else if ((document.data).getValue("name") == "MushokuTensei2") {
                            Horizontal_Namebook2.setText(
                                document.data.getValue("name").toString()
                            )
                            Horizontal_Price2.setText(
                                document.data.getValue("price").toString()
                            )
                            Picasso.get().load(document.data.getValue("url_img").toString())
                                .into(Horizontal_img2)
                            Horizontal_urlimg2.setText(
                                document.data.getValue("url_img").toString()
                            )
                        } else if ((document.data).getValue("name") == "MushokuTensei3") {
                            Horizontal_Namebook3.setText(
                                document.data.getValue("name").toString()
                            )
                            Horizontal_Price3.setText(
                                document.data.getValue("price").toString()
                            )
                            Picasso.get().load(document.data.getValue("url_img").toString())
                                .into(Horizontal_img3)
                            Horizontal_urlimg3.setText(
                                document.data.getValue("url_img").toString()
                            )
                        } else if ((document.data).getValue("name") == "MushokuTensei5") {
                            Horizontal_Namebook5.setText(
                                document.data.getValue("name").toString()
                            )
                            Horizontal_Price5.setText(
                                document.data.getValue("price").toString()
                            )
                            Picasso.get().load(document.data.getValue("url_img").toString())
                                .into(Horizontal_img5)
                            Horizontal_urlimg5.setText(
                                document.data.getValue("url_img").toString()
                            )
                        } else if ((document.data).getValue("name") == "MushokuTensei6") {
                            FCL_Linear_1_Namebook.setText(
                                document.data.getValue("name").toString()
                            )
                            FCL_Linear_1_Price.setText(
                                document.data.getValue("price").toString()
                            )
                            Picasso.get().load(document.data.getValue("url_img").toString())
                                .into(FCL_Linear_1_img)
                            FCL_Linear_1_urlimg.setText(
                                document.data.getValue("url_img").toString()
                            )
                        } else if ((document.data).getValue("name") == "MushokuTensei7") {
                            FCL_Linear_2_Namebook.setText(
                                document.data.getValue("name").toString()
                            )
                            FCL_Linear_2_Price.setText(
                                document.data.getValue("price").toString()
                            )
                            Picasso.get().load(document.data.getValue("url_img").toString())
                                .into(FCL_Linear_2_img)
                            FCL_Linear_2_urlimg.setText(
                                document.data.getValue("url_img").toString()
                            )
                            SCL_Linear_1_Namebook.setText(
                                document.data.getValue("name").toString()
                            )
                            SCL_Linear_1_Price.setText(
                                document.data.getValue("price").toString()
                            )
                            Picasso.get().load(document.data.getValue("url_img").toString())
                                .into(SCL_Linear_1_img)
                            SCL_Linear_1_urlimg.setText(
                                document.data.getValue("url_img").toString()
                            )
                        } else if ((document.data).getValue("name") == "MushokuTensei8") {
                            FCL_Linear_3_Namebook.setText(
                                document.data.getValue("name").toString()
                            )
                            FCL_Linear_3_Price.setText(
                                document.data.getValue("price").toString()
                            )
                            Picasso.get().load(document.data.getValue("url_img").toString())
                                .into(FCL_Linear_3_img)
                            FCL_Linear_3_urlimg.setText(
                                document.data.getValue("url_img").toString()
                            )
                        } else if ((document.data).getValue("name") == "MushokuTensei10") {
                            SCL_Linear_2_Namebook.setText(
                                document.data.getValue("name").toString()
                            )
                            SCL_Linear_2_Price.setText(
                                document.data.getValue("price").toString()
                            )
                            Picasso.get().load(document.data.getValue("url_img").toString())
                                .into(SCL_Linear_2_img)
                            SCL_Linear_2_urlimg.setText(
                                document.data.getValue("url_img").toString()
                            )
                        } else if ((document.data).getValue("name") == "MushokuTensei11") {
                            SCL_Linear_3_Namebook.setText(
                                document.data.getValue("name").toString()
                            )
                            SCL_Linear_3_Price.setText(
                                document.data.getValue("price").toString()
                            )
                            Picasso.get().load(document.data.getValue("url_img").toString())
                                .into(SCL_Linear_3_img)
                            SCL_Linear_3_urlimg.setText(
                                document.data.getValue("url_img").toString()
                            )
                        } else if ((document.data).getValue("name") == "MushokuTensei12") {
                            TCL_Linear_1_Namebook.setText(
                                document.data.getValue("name").toString()
                            )
                            TCL_Linear_1_Price.setText(
                                document.data.getValue("price").toString()
                            )
                            Picasso.get().load(document.data.getValue("url_img").toString())
                                .into(TCL_Linear_1_img)
                            TCL_Linear_1_urlimg.setText(
                                document.data.getValue("url_img").toString()
                            )
                        } else if ((document.data).getValue("name") == "MushokuTensei13") {
                            TCL_Linear_2_Namebook.setText(
                                document.data.getValue("name").toString()
                            )
                            TCL_Linear_2_Price.setText(
                                document.data.getValue("price").toString()
                            )
                            Picasso.get().load(document.data.getValue("url_img").toString())
                                .into(TCL_Linear_2_img)
                            TCL_Linear_2_urlimg.setText(
                                document.data.getValue("url_img").toString()
                            )
                            Horizontal_Namebook4.setText(
                                document.data.getValue("name").toString()
                            )
                            Horizontal_Price4.setText(
                                document.data.getValue("price").toString()
                            )
                            Picasso.get().load(document.data.getValue("url_img").toString())
                                .into(Horizontal_img4)
                            Horizontal_urlimg4.setText(
                                document.data.getValue("url_img").toString()
                            )
                        } else if ((document.data).getValue("name") == "MushokuTensei14") {
                            TCL_Linear_3_Namebook.setText(
                                document.data.getValue("name").toString()
                            )
                            TCL_Linear_3_Price.setText(
                                document.data.getValue("price").toString()
                            )
                            Picasso.get().load(document.data.getValue("url_img").toString())
                                .into(TCL_Linear_3_img)
                            TCL_Linear_3_urlimg.setText(
                                document.data.getValue("url_img").toString()
                            )
                        }
                    }
                }
            })
        //firebase close
    }

    fun add_fav(userid: String, bookname: String, bookurl: String) {
        val intent_userid = Intent(this@MainActivity, MainActivity2::class.java)
        intent_userid.putExtra("userid", userid.toString())
        Toast.makeText(this, "Add favorite", Toast.LENGTH_SHORT).show()
        val mFireStore = FirebaseFirestore.getInstance()
        val user = HashMap<String, Any>()
        user["userid"] = userid
        user["name"] = bookname
        user["url_img"] = bookurl
        mFireStore.collection("Fav").document()
            .set(user)
    }
}