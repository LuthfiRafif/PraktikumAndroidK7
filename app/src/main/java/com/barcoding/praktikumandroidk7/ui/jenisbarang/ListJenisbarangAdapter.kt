package com.barcoding.praktikumandroidk7.ui.jenisbarang

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barcoding.praktikumandroidk7.databinding.ItemRowJenisbarangBinding
import com.barcoding.praktikumandroidk7.model.JenisbarangData

class ListJenisbarangAdapter (private val listJenisbarang: ArrayList<JenisbarangData>) : RecyclerView.Adapter<ListJenisbarangAdapter.ListViewHolder>() {

    class ListViewHolder(private val binding: ItemRowJenisbarangBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(jenisbarangData: JenisbarangData) {
            with(binding){
                tvNamajenisbarang.text = jenisbarangData.namajenisbarang
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowJenisbarangBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listJenisbarang[position])
    }

    override fun getItemCount():Int = listJenisbarang.size
}