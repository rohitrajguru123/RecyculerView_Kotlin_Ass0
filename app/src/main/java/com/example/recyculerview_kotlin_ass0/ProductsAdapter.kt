package com.example.recyculerview_kotlin_ass0

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(
    private val homeproduct: ArrayList<HomeProduct>,
    private val digitalproduct: ArrayList<DigitalProduct>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_HOMPROD = 1
    private val VIEW_DIGIPROD = 2

    class HomeProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val homeProdutImg : ImageView = itemView.findViewById(R.id.homeProdutImg)
        private val homeProdName : TextView = itemView.findViewById(R.id.homeProdName)
        private  val homeProdPrice : TextView = itemView.findViewById(R.id.homeProdPrice)

        fun bind(homeProduct: HomeProduct) {
            homeProdutImg.setImageResource(homeProduct.imageResId)
            homeProdName.text = homeProduct.homProdName
            homeProdPrice.text = "${homeProduct.homProdPrice}"
        }
    }
    class DigitalProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val digitalProdutImg : ImageView = itemView.findViewById(R.id.digitalProdutImg)
        private val digitalProdName : TextView = itemView.findViewById(R.id.digitalProdName)
        private val digitalProdPrice : TextView = itemView.findViewById(R.id.digitalProdPrice)

        fun bind(digitalProduct: DigitalProduct){
            digitalProdutImg.setImageResource(digitalProduct.imageReId)
            digitalProdName.text = digitalProduct.digiProdName
            digitalProdPrice.text = "${digitalProduct.digiProdPrice}"
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 3 == 0 && position / 3 <homeproduct.size) VIEW_HOMPROD else VIEW_DIGIPROD
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_HOMPROD){
            val homeProduct = layoutInflater.inflate(R.layout.homeapplice_view_holder,parent,false)
            HomeProductViewHolder(homeProduct)
        }else{
            val digitalProdct = layoutInflater.inflate(R.layout.digital_prod_vieholder,parent,false)
            DigitalProductViewHolder(digitalProdct)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeProductViewHolder){
            val homeproductIndex = (position-1) / 3
            if (homeproductIndex < homeproduct.size){
                val  homeprod = homeproduct[homeproductIndex]
                holder.bind(homeprod)
            }
        }else if (holder is DigitalProductViewHolder){
            val digitalprodctIndex = position / 2
            if (digitalprodctIndex < digitalproduct.size){
                val digitalprod = digitalproduct[digitalprodctIndex]
                holder.bind(digitalprod)
            }
        }
    }
    override fun getItemCount(): Int {
        return homeproduct.size + digitalproduct.size
    }
}
