package it.t4group.androidsunflower.data.plants

class PlantRepository private constructor(private val plantDao: PlantDao) {

    fun getPlants() = plantDao.getPlants()

    fun getPlant(plantID: String) = plantDao.getPlant(plantID)

    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int) =
            plantDao.getPlantsWithGrowZoneNumber(growZoneNumber)

    companion object {

        @Volatile
        private var instance: PlantRepository? = null

        fun getInstance(plantDao: PlantDao) = instance
                ?: synchronized(this) {
            instance
                    ?: PlantRepository(plantDao).also {
                instance = it
            }
        }

    }

}