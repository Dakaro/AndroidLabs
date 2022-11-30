package com.example.todolist


import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.todolist.databinding.FragmentMainBinding
import com.example.todolist.ui.main.MainViewModel


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }


 //   var stringList = arrayListOf<String>("item7", "item2", "item3", "item4", "item5", "item6", "item1", "item2", "item3", "item4", "item5", "item6", "item1", "item2", "item3", "item4", "item5", "item6", "item1", "item2", "item3", "item4", "item5", "item6")
    var todoList: ArrayList<String> = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

      //  val listItemBinding = DataBindingUtil.setContentView<ViewDataBinding>(requireActivity(), R.id.FragmentList) // (layoutInflater, R.id.FragmentList, viewList , false)

      //  val product: MainViewModel = MainViewModel("nazwa1", "opis1", "data1", false)

        val binding: FragmentMainBinding = FragmentMainBinding.inflate(inflater)

        binding.product1  = MainViewModel("nazwa1", "desc1", "data1", false)
        binding.product2 = MainViewModel("nazwa2", "desc2", "data2", true)

        return binding.root

    }


}

