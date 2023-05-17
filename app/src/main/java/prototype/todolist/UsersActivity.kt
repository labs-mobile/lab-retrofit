package prototype.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import prototype.todolist.viewmodel.UserActivityViewModel
import prototype.todolist.databinding.ActivityUsersBinding
import prototype.todolist.models.User
import prototype.todolist.ui.UserRecyclerViewAdapter
import prototype.todolist.utils.Status

class UsersActivity : AppCompatActivity() {


    private val viewModel: UserActivityViewModel by viewModels()
    private lateinit var adapter: UserRecyclerViewAdapter
    private lateinit var binding: ActivityUsersBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        // ViewBinding
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Init recyclerView
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@UsersActivity)
            adapter = UserRecyclerViewAdapter(arrayListOf())
            recyclerView.addItemDecoration(
                DividerItemDecoration(
                    recyclerView.context,
                    (recyclerView.layoutManager as LinearLayoutManager).orientation
                )
            )
            recyclerView.adapter = adapter
        }

        // getUsers observe
        viewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                    retrieveList(it.data!!)
                }
                Status.ERROR -> {
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
            }
        })
    }


    private fun retrieveList(users: List<User>) {
        adapter.apply {
            addUsers(users)
            notifyDataSetChanged()
        }
    }


}
