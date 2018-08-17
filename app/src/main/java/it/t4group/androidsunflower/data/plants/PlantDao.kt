package it.t4group.androidsunflower.data.plants

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import it.t4group.androidsunflower.data.plants.PLANTS
import it.t4group.androidsunflower.data.plants.Plant

@Dao
interface PlantDao {

    @Query("SELECT * FROM $PLANTS ORDER BY name")
    fun getPlants(): LiveData<List<Plant>>

    @Query("SELECT * FROM $PLANTS WHERE growZoneNumber=:growZoneNumber ORDER BY name")
    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): LiveData<List<Plant>>

    @Query("SELECT * FROM $PLANTS WHERE id=:id")
    fun getPlant(id: String): LiveData<Plant>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plants: List<Plant>)

}