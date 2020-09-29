package com.example.aleemullah.fingerfood.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class FragmentAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    //Create Variables here

    var mfm = fm
    var mFragmentitems:ArrayList<Fragment> = ArrayList()
    var mFragmentTitles:ArrayList<String> = ArrayList()

    //Create function to add fragments

    fun addFragments(fragmentItems:Fragment, fragmentTitles:String){
        mFragmentitems.add(fragmentItems)
        mFragmentTitles.add(fragmentTitles)
    }

    override fun getItem(p0: Int): Fragment {
        return mFragmentitems[p0]
    }

    override fun getCount(): Int {
        return mFragmentTitles.size
    }

    //Override getPageTitle fun

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitles[position]
    }


}