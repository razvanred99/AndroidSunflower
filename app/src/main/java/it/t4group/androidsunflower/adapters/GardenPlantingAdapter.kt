package it.t4group.androidsunflower.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import it.t4group.androidsunflower.R
import it.t4group.androidsunflower.data.PlantAndGardenPlantings
import it.t4group.androidsunflower.databinding.ListItemGardenPlantingBinding
import it.t4group.androidsunflower.viewmodels.PlantAndGardenPlantingsViewModel

class GardenPlantingAdapter : ListAdapter<PlantAndGardenPlantings, GardenPlantingAdapter.ViewHolder>(GardenPlantDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let {
            with(holder) {
                itemView.tag = it
                bind(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_item_garden_planting, parent, false))

    inner class ViewHolder(private val binding: ListItemGardenPlantingBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(plantings: PlantAndGardenPlantings) {

            with(binding) {
                viewModel = PlantAndGardenPlantingsViewModel(itemView.context, plantings)
                executePendingBindings()
            }

        }

    }

}