package it.t4group.androidsunflower.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import it.t4group.androidsunflower.PlantListFragmentDirections
import it.t4group.androidsunflower.data.plants.Plant
import it.t4group.androidsunflower.databinding.ListItemPlantBinding

class PlantAdapter : ListAdapter<Plant, PlantAdapter.ViewHolder>(PlantDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ListItemPlantBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val plant = getItem(position)
        holder.apply {
            bind(createOnClickListener(plant.id), plant)
            itemView.tag = plant
        }
    }

    private fun createOnClickListener(plantID: String) =
            View.OnClickListener {
                val direction = PlantListFragmentDirections.ActionPlantListFragmentToPlantDetailFragment(plantID)
                it.findNavController().navigate(direction)
            }

    inner class ViewHolder(private val binding: ListItemPlantBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Plant) {
            binding.apply {
                clickListener = listener
                plant = item
                executePendingBindings()
            }
        }

    }

}