package pt.tiago.computacaomovel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main2.*
import pt.tiago.computacaomovel.adapter.LineAdapter


import pt.tiago.computacaomovel.dataclasses.Place



class MainActivity2 : AppCompatActivity() {

    private lateinit var myList: ArrayList<Place>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //val message = intent.getStringExtra(PARAM1_NAME)

        myList = ArrayList<Place>()

        for(i in 0 until 500){
            myList.add(Place("Country $i", i*500, "Capital $i"))
        }


        recycler_view.adapter = LineAdapter(myList)
        recycler_view.layoutManager = LinearLayoutManager(this)

        /*val textView = findViewById<TextView>(R.id.textMain2).apply {
            text = message
        }*/
        }



    fun insert(view: View){
        myList.add(0, Place("Country XXX", 999, "Capital XXX"))
        recycler_view.adapter?.notifyDataSetChanged()
    }

}