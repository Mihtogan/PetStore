package com.example.petstore.data.recyclers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.petstore.R
import com.example.petstore.databinding.ItemRecyclerBinding

class PetAdapter(private val listener: (PetCardItem) -> Unit) :
    ListAdapter<PetCardItem, PetAdapter.PetHolder>(Comparator()) {

   inner class PetHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemRecyclerBinding.bind(item)

        fun bind(pet: PetCardItem) = with(binding) {
            root.setOnClickListener {
                listener(pet)
            }

            imageView.setImageResource(pet.image)
            tvName.text = pet.name
            tvCategory.text = pet.category
        }
    }

    class Comparator : DiffUtil.ItemCallback<PetCardItem>() {
        override fun areItemsTheSame(
            oldItem: PetCardItem,
            newItem: PetCardItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: PetCardItem,
            newItem: PetCardItem
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return PetHolder(view)
    }

    override fun onBindViewHolder(holder: PetHolder, position: Int) {
        holder.bind(getItem(position))
    }
}