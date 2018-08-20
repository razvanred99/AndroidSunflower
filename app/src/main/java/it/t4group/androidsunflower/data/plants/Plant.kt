package it.t4group.androidsunflower.data.plants

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import java.util.Calendar.DAY_OF_YEAR

const val PLANTS = "Plants"

@Entity(tableName = PLANTS)
data class Plant(
        @PrimaryKey
        val id: String,
        val name: String,
        val growZoneNumber: Int,
        val wateringInterval: Int = 7,
        val imageUrl: String = ""
) {

    fun shouldBeWatered(lastWateringDate: Calendar) = Calendar.getInstance() > lastWateringDate.apply { add(DAY_OF_YEAR, wateringInterval) }

    override fun toString() = name

}