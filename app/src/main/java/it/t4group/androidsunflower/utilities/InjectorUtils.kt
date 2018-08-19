package it.t4group.androidsunflower.utilities

import android.content.Context
import it.t4group.androidsunflower.data.AppDatabase
import it.t4group.androidsunflower.data.gardenplanting.GardenPlantingRepository
import it.t4group.androidsunflower.data.plants.PlantRepository

object InjectorUtils {

    private fun getPlantRepository(context: Context) =
            PlantRepository.getInstance(AppDatabase.getInstance(context).plantDao())

    private fun getGardenPlantingRepository(context: Context) =
            GardenPlantingRepository.getInstance(AppDatabase.getInstance(context).gardenPlantingDao())

    fun provideGardenPlantingListViewModelFactory(context: Context): Nothing = TODO()

}