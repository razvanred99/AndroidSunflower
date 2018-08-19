package it.t4group.androidsunflower.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import it.t4group.androidsunflower.data.gardenplanting.GardenPlantingRepository
import it.t4group.androidsunflower.data.plants.PlantRepository

class PlantDetailViewModelFactory(private val plantRepository: PlantRepository,
                                  private val gardenPlantingRepository: GardenPlantingRepository,
                                  private val plantID: String) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlantDetailViewModel(plantRepository, gardenPlantingRepository, plantID) as T
    }

}