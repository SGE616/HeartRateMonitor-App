package com.example.heartrateproj

import android.icu.text.AlphabeticIndex
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class RecordlistActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var recordRecyclerview : RecyclerView
    private lateinit var recordArrayList : ArrayList<Record>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recordslist)

        recordRecyclerview = findViewById(R.id.userList)
        recordRecyclerview.layoutManager = LinearLayoutManager(this)
        recordRecyclerview.setHasFixedSize(true)

        recordArrayList = arrayListOf<Record>()
        getUserData()

    }

    private fun getUserData() {

        dbref = FirebaseDatabase.getInstance().getReference("Records")

        dbref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){
                    recordArrayList = arrayListOf()

                    for (userSnapshot in snapshot.children){

                        val record = userSnapshot.getValue(Record::class.java)
                        recordArrayList.add(record!!)

                    }

                    recordRecyclerview.adapter = RecordlistAdapter(recordArrayList)


                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }
}