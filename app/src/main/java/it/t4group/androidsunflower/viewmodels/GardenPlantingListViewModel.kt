package it.t4group.androidsunflower.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import it.t4group.androidsunflower.data.PlantAndGardenPlantings
import it.t4group.androidsunflower.data.gardenplanting.GardenPlantingRepository

class GardenPlantingListViewModel internal constructor(gardenPlantingRepository: GardenPlantingRepository) : ViewModel() {

    val gardenPlantings = gardenPlantingRepository.getGardenPlantings()

    val plantAndGardenPlantings: LiveData<List<PlantAndGardenPlantings>> =
            Transformations.map(gardenPlantingRepository.getPlantAndGardenPlantings()) { plantAndGardenPlantings ->
                plantAndGardenPlantings.filter { it.gardenPlantings.isNotEmpty() }
            }

}