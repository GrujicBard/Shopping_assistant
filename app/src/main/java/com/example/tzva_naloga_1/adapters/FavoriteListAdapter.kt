package com.example.tzva_naloga_1.adapters

import android.annotation.SuppressLint
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.database.ItemViewModel
import com.example.tzva_naloga_1.database.entities.ItemEntity

class FavoriteListAdapter(
    private val onItemClickListener: OnItemClickListener,
    private val owner: LifecycleOwner,
    //val onItemLongClickListener: OnItemLongClickListener,
    private var dataset: LiveData<MutableList<ItemEntity>>,
    private val itemViewModel: ItemViewModel,
    private val showMenuDelete: (Boolean) -> Unit,
) :
    ListAdapter<ItemEntity, FavoriteListAdapter.ItemViewHolder>(ItemDiffCallback()) {
    private var isEnable = false
    private var isSelectAll = false
    private var itemSelectedList = mutableListOf<Int>()
    private var itemsList: MutableList<ItemEntity>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        dataset.observe(owner) { items ->
            submitList(items)
            itemsList = items
        }
        val inflater = LayoutInflater.from(parent.context)

        return ItemViewHolder(inflater.inflate(R.layout.recyclerview_item, parent, false))
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val rv_tv_name: TextView = itemView.findViewById(R.id.rv_tv_name);
        val rv_tv_stock: TextView = itemView.findViewById(R.id.rv_tv_stock);
        val rv_cb: ImageView = itemView.findViewById(R.id.rv_cb);

        init {
            itemView.setOnClickListener {
                val position = absoluteAdapterPosition
                val item = getItem(position)
                if (itemSelectedList.contains(position)) {
                    itemSelectedList.remove(position)
//                    if(rv_cb.visibility == View.VISIBLE){
//                        rv_cb.visibility = View.GONE
//                    }
                    rv_cb.setImageResource(R.drawable.ic_baseline_check_box_outline_blank_24)
                    itemsList?.get(position)?.selected  = false
                    itemsList?.get(position)?.isFavoriteItem  = true
//                    if(itemSelectedList.isEmpty()){
//                        showMenuDelete(false)
//                        isEnable = false
//                    }
                } else if (isEnable) {
                    if(isSelectAll){
                        rv_cb.visibility = View.VISIBLE
                        rv_cb.setImageResource(R.drawable.ic_baseline_check_box_24)
                    }
                    selectItem(this, item, position)
                } else {
                    onItemClickListener.onItemClick(getItem(position))
                }
            }
            /* itemView.setOnLongClickListener {
                val position = adapterPosition
                onItemLongClickListener.onItemLongClick(getItem(position))
                true
            }*/
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        val item_name = item.name + ", " + item.quantity
        holder.apply {
            rv_tv_name.text = item_name
            rv_tv_stock.text =
                itemView.resources.getString(R.string.rv_stock, item.stock.toString())
            if(!isEnable){
                rv_cb.visibility = View.GONE
            }else{
                rv_cb.visibility = View.VISIBLE
                if(isSelectAll){
                    rv_cb.setImageResource(R.drawable.ic_baseline_check_box_24)
                }else if(!isSelectAll){
//                    rv_cb.visibility = View.GONE
                    rv_cb.setImageResource(R.drawable.ic_baseline_check_box_outline_blank_24)
                }
            }
            itemView.setOnLongClickListener {
                selectAll()
                selectAll()
                rv_cb.visibility = View.VISIBLE
                holder.rv_cb.setImageResource(R.drawable.ic_baseline_check_box_24) //doesn't work for some reason
                selectItem(holder, item, position)
                true
            }
        }
    }

    private fun selectItem(
        holder: FavoriteListAdapter.ItemViewHolder,
        item: ItemEntity,
        position: Int,
    ) {
        isEnable = true
        itemSelectedList.add(position)
        itemsList?.get(position)?.selected = true
        itemsList?.get(position)?.isFavoriteItem  = false
        if(holder.rv_cb.visibility == View.GONE){
            holder.rv_cb.visibility = View.VISIBLE
        }
        holder.rv_cb.setImageResource(R.drawable.ic_baseline_check_box_24)
        showMenuDelete(true)
    }

    fun deleteSelectedItem() {
        if(itemSelectedList.isNotEmpty()){
            itemsList?.let { itemViewModel.updateItems(it) }
            isSelectAll = false
            isEnable = false
            itemSelectedList.clear()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun selectAll(){
        if(isSelectAll){
            isSelectAll = false
            itemSelectedList.clear()
            resetItemsList()
        }else{
            isSelectAll = true
            for (i in 0 until itemsList!!.size) {
                itemSelectedList.add(i)
                itemsList!![i].selected = true
                itemsList!![i].isFavoriteItem = false
            }
        }
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun close(){
        isEnable = false
        isSelectAll = false
        itemSelectedList.clear()
        resetItemsList()
        notifyDataSetChanged()
    }

    fun isSelectAll(): Boolean{
        return isSelectAll
    }

    private fun resetItemsList(){
        for(x in itemsList!!){
            x.selected = false
            x.isFavoriteItem = true
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun resetAdapter(){
        isEnable = false;
        isSelectAll = false;
        itemSelectedList.clear()
        showMenuDelete(false)
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(item: ItemEntity)
    }
}