package it.t4group.androidsunflower.adapters

import android.content.Context
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import it.t4group.androidsunflower.data.PlantAndGardenPlantings

class GardenPlantingAdapter(val context: Context) : ListAdapter<PlantAndGardenPlantings, GardenPlantingAdapter.ViewHolder(GardenPlantDiffCallback()) {

    inner class ViewHolder(private val binding: ListItemGardenPlantingBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(plantings: PlantAndGardenPlantings) {

            with(binding) {

            }

        }

    }

}