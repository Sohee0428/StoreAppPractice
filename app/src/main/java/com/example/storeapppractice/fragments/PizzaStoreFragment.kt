package com.example.storeapppractice.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.storeapppractice.R
import com.example.storeapppractice.StoreDetailActivity
import com.example.storeapppractice.adapters.ListViewAdapter
import com.example.storeapppractice.datas.Store
import kotlinx.android.synthetic.main.fragment_store_pizza.*

class PizzaStoreFragment : Fragment() {

    val pizzaStoreDataList = ArrayList<Store>()

    lateinit var pizzaStoreAdapter : ListViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_store_pizza, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        pizzaStoreDataList.add(Store("A 피자 가게", "1111-5555", "https://cdn3.iconfinder.com/data/icons/street-food-and-food-trucker-1/64/pizza-fast-food-bake-bread-128.png"))
        pizzaStoreDataList.add( Store("B 피자 가게", "2222-5555", "https://cdn1.iconfinder.com/data/icons/cartoon-snack/128/pizza-128.png"))
        pizzaStoreDataList.add( Store("C 피자 가게", "3333-5555", "https://cdn3.iconfinder.com/data/icons/food-set-3/91/Food_C219-128.png"))
        pizzaStoreDataList.add( Store("D 피자 가게", "4444-5555", "https://cdn0.iconfinder.com/data/icons/fastfood-31/64/pizza-italian-food-fast-fastfood-cheese-piece-128.png"))

        pizzaStoreAdapter = ListViewAdapter(requireContext(), R.layout.pizza_list_item, pizzaStoreDataList)

        PizzaListView.adapter = pizzaStoreAdapter

        PizzaListView.setOnItemClickListener { parent, view, position, id ->

            val clickedStore = pizzaStoreDataList[position]

            val myIntent = Intent(requireContext(), StoreDetailActivity::class.java)

            myIntent.putExtra("storeData", clickedStore)

            startActivity(myIntent)

        }

    }

}