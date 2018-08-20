package it.t4group.androidsunflower.data.gardenplanting

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import it.t4group.androidsunflower.data.PlantAndGardenPlantings

@Dao
interface GardenPlantingDao {

    @Query("SELECT * FROM $GARDEN_PLANTINGS")
    fun getGardenPlantings(): LiveData<List<GardenPlanting>>

    @Query("SELECT * FROM $GARDEN_PLANTINGS WHERE id=:id")
    fun getGardenPlanting(id: Long): LiveData<GardenPlanting>

    @Query("SELECT * FROM $GARDEN_PLANTINGS WHERE plantID=:plantID")
    fun getGardenPlantingForPlant(plantID: String): LiveData<List<GardenPlanting>>

    @Transaction
    @Query("SELECT * FROM Plants")
    fun getPlantAndGardenPlantings(): LiveData<List<PlantAndGardenPlantings>>

    @Insert
    fun insertGardenPlanting(gardenPlanting: GardenPlanting): Long

}