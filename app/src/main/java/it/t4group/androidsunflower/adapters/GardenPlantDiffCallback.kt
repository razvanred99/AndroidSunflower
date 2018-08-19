package it.t4group.androidsunflower.adapters

import android.support.v7.util.DiffUtil
import it.t4group.androidsunflower.data.PlantAndGardenPlantings

class GardenPlantDiffCallback : DiffUtil.ItemCallback<PlantAndGardenPlantings>() {

    override fun areContentsTheSame(oldItem: PlantAndGardenPlantings?, newItem: PlantAndGardenPlantings?): Boolean {
        return oldItem?.plant?.id == newItem?.plant?.id
    }

    override fun areItemsTheSame(oldItem: PlantAndGardenPlantings?, newItem: PlantAndGardenPlantings?): Boolean {
        return oldItem?.plant == newItem?.plant
    }

}