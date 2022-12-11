package com.example.zakupy.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zakupy.R
import com.example.zakupy.databinding.FragmentDashboardBinding
import com.example.zakupy.ui.home.ProductAdapter

class DashboardFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_dashboard, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewShop)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ShopAdapter()

        return view


    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}