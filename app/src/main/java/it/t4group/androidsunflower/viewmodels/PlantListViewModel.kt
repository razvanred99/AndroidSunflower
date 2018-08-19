package it.t4group.androidsunflower.viewmodels

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import it.t4group.androidsunflower.data.plants.Plant
import it.t4group.androidsunflower.data.plants.PlantRepository

private const val NO_GROW_ZONE = -1

class PlantListViewModel internal constructor(private val plantRepository: PlantRepository) : ViewModel() {

    private val growZoneNumber = MutableLiveData<Int>()

    private val plantList = MediatorLiveData<List<Plant>>()

    init {

        growZoneNumber.value = NO_GROW_ZONE

        val livePlantList = Transformations.switchMap(growZoneNumber) {
            if (it == NO_GROW_ZONE)
                plantRepository.getPlants()
            else
                plantRepository.getPlantsWithGrowZoneNumber(it)
        }

        plantList.addSource(livePlantList, plantList::setValue)

    }

    fun getPlants() = plantList

    fun setGrowZoneNumber(num: Int) {
        growZoneNumber.value = num
    }

    fun clearGrowZoneNumber() {
        growZoneNumber.value = NO_GROW_ZONE
    }

    fun isFiltered() = growZoneNumber.value != NO_GROW_ZONE

}