package com.example.storeapppractice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.storeapppractice.fragments.ChickenStoreFragment
import com.example.storeapppractice.fragments.PizzaStoreFragment

class MainViewPagerAdapter (fm : FragmentManager) : FragmentPagerAdapter (fm) {
    override fun getItem(position: Int): Fragment {
        if(position == 0) {
            return PizzaStoreFragment()
        }
        else {
            return ChickenStoreFragment()
        }
    }

    override fun getCount(): Int {

        return 2

    }

}