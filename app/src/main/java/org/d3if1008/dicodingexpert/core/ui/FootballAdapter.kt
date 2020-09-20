package org.d3if1008.dicodingexpert

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list_football.view.*
import java.util.ArrayList

class FootballAdapter : RecyclerView.Adapter<FootballAdapter.ListViewHolder>() {

    private var listData = ArrayList<FootballEntity>()
    var onItemClick: ((FootballEntity) -> Unit)? = null

    fun setData(newListData: List<FootballEntity>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_football, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: FootballEntity) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(iv_item_image)
                tv_item_title.text = data.name
                tv_item_subtitle.text = data.address
            }
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}