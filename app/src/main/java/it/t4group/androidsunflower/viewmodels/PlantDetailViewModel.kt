package it.t4group.androidsunflower.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import it.t4group.androidsunflower.data.gardenplanting.GardenPlantingRepository
import it.t4group.androidsunflower.data.plants.Plant
import it.t4group.androidsunflower.data.plants.PlantRepository

class PlantDetailViewModel(plantRepository: PlantRepository,
                           private val gardenPlantingRepository: GardenPlantingRepository,
                           private val plantID: String) : ViewModel() {

    val isPlanted: LiveData<Boolean>
    val plant: LiveData<Plant>

    init {
        val gardenPlantingForPlanting = gardenPlantingRepository.getGardenPlantingForPlant(plantID)
        isPlanted = Transformations.map(gardenPlantingForPlanting) { it != null }

        plant = plantRepository.getPlant(plantID)
    }

    fun addPlantToGarden() {
        gardenPlantingRepository.createGardenPlanting(plantID)
    }

}