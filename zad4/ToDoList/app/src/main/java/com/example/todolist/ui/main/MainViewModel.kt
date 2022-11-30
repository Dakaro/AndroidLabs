package com.example.todolist.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.MainFragment
import com.example.todolist.databinding.FragmentMainBinding


data class MainViewModel(val name: String, val desc: String, val date: String, var status: Boolean) : ViewModel()

/*
class MainViewModelHolder(
    private val binding: FragmentMainBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(temp: MainViewModel) {
        binding.product1 = temp
    }
}

class ProductAdapter( private val productsList: MainViewModel ) : RecyclerView.Adapter<MainViewModelHolder>() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewModelHolder {
        binding = FragmentMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewModelHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewModelHolder, position: Int) {
        val tempProd = productsList
        holder.bind(tempProd)
    }

    override fun getItemCount(): Int = 1

}

 */