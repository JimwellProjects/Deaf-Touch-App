package edu.ucu.cite.deaftouchapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class  ItemAdapter( var clickedItem: ClickedItem): RecyclerView.Adapter<ItemAdapter.ItemAdapterVH>(), Filterable {

    var itemModalList = ArrayList<ItemModal>()
    var itemModalListFilter = ArrayList<ItemModal>()

    fun setData( itemModalList: ArrayList<ItemModal>){
        this.itemModalList = itemModalList
        this.itemModalListFilter = itemModalList
        notifyDataSetChanged()
    }
     interface ClickedItem{
         fun clickedItem(itemModal: ItemModal)
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapterVH {
       return ItemAdapterVH(
           LayoutInflater.from(parent.context).inflate(R.layout.category_content, parent, false)
       )
    }

    override fun getItemCount(): Int {
        return itemModalList.size
    }

    override fun onBindViewHolder(holder: ItemAdapterVH, position: Int) {
       var itemModal = itemModalList[position]

        holder.itemImage.setImageResource(itemModal.image)
        holder.itemTitle.text = itemModal.name
        holder.itemDetail.text = itemModal.desc

        holder.itemView.setOnClickListener {
            clickedItem.clickedItem(itemModal)

        }
    }



    class ItemAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.imageView)
            itemTitle = itemView.findViewById(R.id.tvName)
            itemDetail = itemView.findViewById(R.id.tvDesc)
        }

    }

    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence?): FilterResults {

                var filterResults = FilterResults()
                if(charSequence == null || charSequence.isEmpty()){

                    filterResults.count = itemModalListFilter.size
                    filterResults.values = itemModalListFilter

                }else{
                    var searchChr: String = charSequence.toString().toLowerCase()
                    var itemModal = ArrayList<ItemModal>()
                    for(items in itemModalListFilter){
                        if(items.name.toLowerCase().contains(searchChr) || items.desc.toLowerCase().contains(searchChr)){

                            itemModal.add(items)
                        }
                    }
                    filterResults.count = itemModal.size
                    filterResults.values = itemModal

                }

                return  filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                itemModalList = p1!!.values as ArrayList<ItemModal>
                notifyDataSetChanged()
            }

        }
    }

}

