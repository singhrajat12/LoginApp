package com.example.loginapplication
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginapplication.Adapter.RecyclerViewAdapter

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter
    private var dummyData = listOf("John, 25, New York", "Alice, 30, Los Angeles", "Bob, 22, Chicago")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = RecyclerViewAdapter(dummyData)
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_sort_name -> {
                dummyData = dummyData.sortedBy { it.split(",")[0] }
                adapter.updateData(dummyData)
                return true
            }
            R.id.menu_sort_age -> {
                dummyData = dummyData.sortedBy { it.split(",")[1].toInt() }
                adapter.updateData(dummyData)
                return true
            }
            R.id.menu_sort_city -> {
                dummyData = dummyData.sortedBy { it.split(",")[2] }
                adapter.updateData(dummyData)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
