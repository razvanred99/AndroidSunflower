package it.t4group.androidsunflower.adapters

import androidx.recyclerview.widget.DiffUtil
import it.t4group.androidsunflower.data.plants.Plant

class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {

    override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem == newItem
    }

}