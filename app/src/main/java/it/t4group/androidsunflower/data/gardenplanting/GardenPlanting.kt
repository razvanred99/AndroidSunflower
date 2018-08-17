package it.t4group.androidsunflower.data.gardenplanting

import android.arch.persistence.room.*
import it.t4group.androidsunflower.data.plants.Plant
import java.util.*

const val GARDEN_PLANTINGS = "GardenPlantings"

@Entity(tableName = GARDEN_PLANTINGS,
        foreignKeys = [ForeignKey(entity = Plant::class, parentColumns = ["id"], childColumns = ["plantID"])],
        indices = [Index("plantID")])
data class GardenPlanting(val plantID: String,
                          val plantDate: Calendar = Calendar.getInstance(),
                          val lastWateringDate: Calendar = Calendar.getInstance()) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

}