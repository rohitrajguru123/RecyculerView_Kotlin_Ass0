package com.example.recyculerview_kotlin_ass0

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewForViewHold : RecyclerView
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var homeproducts : ArrayList<HomeProduct>
    private lateinit var digitalproduct : ArrayList<DigitalProduct>

    private val homProdImage = arrayOf(R.drawable.homep2,R.drawable.homep3,R.drawable.homep4,R.drawable.homep5)
    private val digiProdImage = arrayOf(R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initViews()
        initArrays()
        initAdapters()

    }
    private fun initViews(){
        recyclerViewForViewHold = findViewById(R.id.recyclerViewForViewHold)
    }

    private fun initArrays(){
        homeproducts = ArrayList()
        for (i in homProdImage.indices){
            homeproducts.add(HomeProduct(homProdImage[i],"Product $i",(i + 1)* 500.0))
        }
        digitalproduct = ArrayList()
        for (i in digiProdImage.indices){
            digitalproduct.add(DigitalProduct(digiProdImage[i],"Product $i",(i + 1)* 500.0))
        }
    }
    private fun initAdapters(){

        productsAdapter = ProductsAdapter(homeproducts,digitalproduct)
        recyclerViewForViewHold.adapter = productsAdapter
        recyclerViewForViewHold.layoutManager = LinearLayoutManager(this)
    }

}