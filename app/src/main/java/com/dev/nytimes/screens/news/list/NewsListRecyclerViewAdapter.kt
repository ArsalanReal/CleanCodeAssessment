package com.dev.nytimes.screens.news.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dev.nytimes.R
import com.dev.nytimes.models.news.AllNewsResult

/**
 * Adapter for News screen recyclerview.
 */
class NewsListRecyclerViewAdapter(val context: Context, list: ArrayList<AllNewsResult>, private val itemClickListener: OnItemClickListener): RecyclerView.Adapter<NewsListRecyclerViewAdapter.NewsViewHolder>() {

    var mItemList = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.landing_list_view_item,parent,false))
    }

    fun updateListItems(updatedList: ArrayList<AllNewsResult>){
        mItemList.clear()
        mItemList = updatedList
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return mItemList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val model : AllNewsResult = mItemList[position]
        holder.bind(model,itemClickListener)
    }

    class NewsViewHolder(item: View): RecyclerView.ViewHolder(item){

        private val title : TextView = item.findViewById(R.id.title)
        private val publishedDate : TextView = item.findViewById(R.id.publishedDate)
        private val byline : TextView = item.findViewById(R.id.byline)
        private val section : TextView = item.findViewById(R.id.section)
        private val image : ImageView = item.findViewById(R.id.image)

        fun bind(news: AllNewsResult,clickListener: OnItemClickListener)
        {
            title.text = news.title
            publishedDate.text = news.published_date
            byline.text = news.byline
            section.text = "Section: "+news.section

            if (news.media.isNotEmpty()) {
                val imageList = news.media[0]
                if(imageList.mediaMetaData.isNotEmpty()) {
                    Glide.with(image.context)
                        .load(imageList.mediaMetaData[0].url)
                        .apply(RequestOptions.circleCropTransform())
                        .override(150,150).into(image)
                }
            }

            itemView.setOnClickListener {
                clickListener.onItemClicked(news)
            }
        }
    }
}

interface OnItemClickListener{
    fun onItemClicked(news: AllNewsResult)
}
