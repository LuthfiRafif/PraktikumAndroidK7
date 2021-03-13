package com.barcoding.praktikumandroidk7.ui.jenisbarang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.barcoding.praktikumandroidk7.R
import com.barcoding.praktikumandroidk7.databinding.ActivityJenisbarangBinding
import com.barcoding.praktikumandroidk7.model.JenisbarangData

class JenisbarangActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJenisbarangBinding
    private val list = ArrayList<JenisbarangData>()
    private val viewModel: JenisbarangViewModel by lazy {
        ViewModelProvider(this).get(JenisbarangViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJenisbarangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvJenisbarang.setHasFixedSize(true)

        binding.progressBarJenisbarang.visibility = View.VISIBLE

        getListJenisbarang()

    }

    private fun getListJenisbarang() {
        viewModel.response.observe(this, {
            binding.progressBarJenisbarang.visibility = View.INVISIBLE
            list.addAll(it.data)
            binding.rvJenisbarang.layoutManager = LinearLayoutManager(this)
            val listJenisbarangAdapter = ListJenisbarangAdapter(list)
            binding.rvJenisbarang.adapter = listJenisbarangAdapter
        })
    }
}