package it.t4group.androidsunflower.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import it.t4group.androidsunflower.data.PlantAndGardenPlantings
import it.t4group.androidsunflower.data.gardenplanting.GardenPlantingRepository

class GardenPlantingListViewModel internal constructor(gardenPlantingRepository: GardenPlantingRepository) : ViewModel() {

    val gardenPlantings = gardenPlantingRepository.getGardenPlantings()

    val plantAndGardenPlantings: LiveData<List<PlantAndGardenPlantings>> =
            Transformations.map(gardenPlantingRepository.getPlantAndGardenPlantings()) { plantAndGardenPlantings ->
                plantAndGardenPlantings.filter { it.gardenPlantings.isNotEmpty() }
            }

}