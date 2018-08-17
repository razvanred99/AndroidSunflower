package it.t4group.androidsunflower.data.gardenplanting

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import it.t4group.androidsunflower.data.PlantGardenPlantings

@Dao
interface GardenPlantingDao{

    @Query("SELECT * FROM $GARDEN_PLANTINGS")
    fun getGardenPlantings():LiveData<List<GardenPlanting>>

    @Query("SELECT * FROM $GARDEN_PLANTINGS WHERE id=:id")
    fun getGardenPlanting(id:Long):LiveData<GardenPlanting>

    @Transaction
    @Query("SELECT * FROM Plants")
    fun getPlantAndGardenPlantings():LiveData<List<PlantGardenPlantings>>

    @Insert
    fun insertGardenPlantind(gardenPlanting:GardenPlanting):Long

}