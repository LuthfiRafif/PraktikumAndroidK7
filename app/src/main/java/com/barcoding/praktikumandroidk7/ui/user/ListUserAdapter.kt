package com.barcoding.praktikumandroidk7.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barcoding.praktikumandroidk7.databinding.ItemRowUserBinding
import com.barcoding.praktikumandroidk7.model.UserData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListUserAdapter(private val listUser: ArrayList<UserData>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    class ListViewHolder(private val binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(userData: UserData) {
            with(binding){
                tvItemName.text = userData.first_name + " " + userData.last_name
                tvItemEmail.text = userData.email

                Glide.with(itemView.context)
                    .load(userData.avatar)
                    .apply(RequestOptions().override(55, 55))
                    .into(ivItemAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount():Int = listUser.size
}