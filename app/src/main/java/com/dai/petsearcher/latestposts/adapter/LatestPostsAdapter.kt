package com.dai.petsearcher.latestposts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dai.core.BaseViewHolder
import com.dai.petsearcher.databinding.ItemPostBinding
import com.dai.petsearcher.model.Pet

class LatestPostsAdapter(
    private val listLostPetPost: List<Pet>,
    private val layout: Int,
//    private val itemClickListener: OnPetClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    //TODO: ADD CODE TO ADAPTER
    private inner class PetsLostListViewHolder(
        val binding: ItemPostBinding,
        val context: Context
        ) :BaseViewHolder<Pet>(binding.root) {

        override fun bind(item: Pet) {
            binding.tvName.text = item.name
//            binding.tvDate.text = item.lostDate
            Glide.with(context).load(item.photo).centerCrop().into(binding.ivPhoto)

            binding.ivPhoto.setOnClickListener {
                Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show()
            }
            itemView.setOnClickListener {
                Toast.makeText(context, "body of item pet:${item.idOwner}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    interface OnPetClickListener {
//TODO: inmplement after get list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = PetsLostListViewHolder(itemBinding, parent.context)
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is PetsLostListViewHolder -> holder.bind(listLostPetPost[position])
        }
    }

    override fun getItemCount(): Int = listLostPetPost.size
}