package com.tapan.retrofitrxkotlin.home.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.tapan.retrofitrxkotlin.R
import com.tapan.retrofitrxkotlin.core.network.response.CellPhone
import kotlinx.android.synthetic.main.row_item.view.*

class CellPhoneAdapter(private val context: Context, private val cellPhones: List<CellPhone>) :

    RecyclerView.Adapter<CellPhoneAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.row_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return cellPhones.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cellPhone = cellPhones[position]
        holder.title.text = cellPhone.name

        if (!TextUtils.isEmpty(cellPhone.imageUrl)) {
            Glide.with(context)
                .load(cellPhone.imageUrl)
                .addListener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        ex: GlideException?, model: Any,
                        target: Target<Drawable>, isFirstResource: Boolean
                    ): Boolean {
                        return true
                    }

                    override fun onResourceReady(
                        resource: Drawable,
                        model: Any,
                        target: Target<Drawable>,
                        dataSource: DataSource,
                        isFirstResource: Boolean
                    ): Boolean {
                        holder.image.setImageDrawable(resource)
                        return true
                    }
                }).into(holder.image)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: AppCompatTextView = view.item_title
        val image: AppCompatImageView = view.image_url
    }
}