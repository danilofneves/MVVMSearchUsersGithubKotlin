package com.github.repositories.ui.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.repositories.data.model.User
import com.github.repositories.databinding.LineItemUsersBinding
import com.squareup.picasso.Picasso

class UserListAdapter() : ListAdapter<User, UserListAdapter.UserViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<User>(){
            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.login == newItem.login
            }
        }
    }

    class UserViewHolder(private val itemBind: LineItemUsersBinding): RecyclerView.ViewHolder(itemBind.root){
        fun bind(user: User){
            itemBind.txname.text = user.login
            Picasso.get().load(user.avatar_url).into(itemBind.image)
        }

        companion object{
            fun create(parent: ViewGroup):UserViewHolder{
                val itemBinding = LineItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)

                return UserViewHolder(itemBinding)
            }
        }
    }

}