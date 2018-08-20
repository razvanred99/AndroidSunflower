package it.t4group.androidsunflower.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import it.t4group.androidsunflower.data.gardenplanting.GardenPlantingRepository

class GardenPlantingListViewModelFactory(private val repository: GardenPlantingRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GardenPlantingListViewModel(repository) as T
    }

}