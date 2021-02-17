package br.edu.iesb.android2.whatsup.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.iesb.android2.whatsup.R
import br.edu.iesb.android2.whatsup.util.Endpoint
import br.edu.iesb.android2.whatsup.util.NetworkUtils
import br.edu.iesb.android2.whatsup.view.adapter.MyItemRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        load()
    }

    fun load() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://jsonplaceholder.typicode.com")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.posts.execute().body()

        recycler_view.adapter = MyItemRecyclerViewAdapter(callback)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }


}