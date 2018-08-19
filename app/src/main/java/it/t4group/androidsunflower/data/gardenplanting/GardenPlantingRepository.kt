package it.t4group.androidsunflower.data.gardenplanting

import it.t4group.androidsunflower.utilities.runOnIOThread

class GardenPlantingRepository private constructor(private val gardenPlantingDao: GardenPlantingDao) {

    fun createGardenPlanting(plantID: String) {
        runOnIOThread {
            val gardenPlanting = GardenPlanting(plantID)
            gardenPlantingDao.insertGardenPlanting(gardenPlanting)
        }
    }

    fun getGardenPlantingForPlant(plantID: String) =
            gardenPlantingDao.getGardenPlantingForPlant(plantID)

    fun getGardenPlantings() = gardenPlantingDao.getGardenPlantings()

    fun getPlantAndGardenPlantings() = gardenPlantingDao.getPlantAndGardenPlantings()

    companion object {

        @Volatile
        private var instance: GardenPlantingRepository? = null

        fun getInstance(gardenPlantingDao: GardenPlantingDao) =
                instance ?: synchronized(this) {
                    instance ?: GardenPlantingRepository(gardenPlantingDao).also {
                        instance = it
                    }
                }

    }

}