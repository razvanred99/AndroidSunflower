package it.t4group.androidsunflower.data.plants

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

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