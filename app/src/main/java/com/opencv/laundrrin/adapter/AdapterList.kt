package com.opencv.laundrrin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.opencv.laundrrin.R
import com.opencv.laundrrin.model.model_paket

class AdapterList(val data: List<model_paket>): RecyclerView.Adapter<AdapterList.ViewHolder>(){

    // code untuk membuat ViewHolder dan menampilkan data ke dalam ViewHolder

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View=LayoutInflater.from(parent.context).inflate(R.layout.fragment_home, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}

//class UserActivity : AppCompatActivity() {
//    private lateinit var userRecyclerView: RecyclerView
//    private lateinit var userAdapter: UserAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_user)
//
//        userRecyclerView = findViewById(R.id.userRecyclerView)
//        userAdapter = UserAdapter(emptyList())
//        userRecyclerView.adapter = userAdapter
//        userRecyclerView.layoutManager = LinearLayoutManager(this)
//
//        // request API menggunakan Retrofit dan Coroutine
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val users = RetrofitClient.userService.getUsers()
//                withContext(Dispatchers.Main) {
//                    userAdapter = UserAdapter(users)
//                    userRecyclerView.adapter = userAdapter
//                }
//            } catch (e: Exception) {
//                Log.e("UserActivity", "Error: ${e.message}")
//            }
//        }
//    }
//}