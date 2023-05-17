package prototype.todolist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import prototype.todolist.R
import prototype.todolist.models.User

class UserRecyclerViewAdapter(private val users: ArrayList<User>) : RecyclerView.Adapter<UserRecyclerViewAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewUserName: TextView = itemView.findViewById<TextView>(R.id.textViewUserName)
        val textViewUserEmail: TextView = itemView.findViewById<TextView>(R.id.textViewUserEmail)
        val imageViewAvatar: ImageView = itemView.findViewById<ImageView>(R.id.imageViewAvatar)

        fun bind(user: User) {
            textViewUserName.text = user.name
            textViewUserEmail.text = user.email
            Glide.with(imageViewAvatar.context)
                .load(user.avatar)
                .into(imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false))

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addUsers(users: List<User>) {
        this.users.apply {
            clear()
            addAll(users)
        }

    }
}