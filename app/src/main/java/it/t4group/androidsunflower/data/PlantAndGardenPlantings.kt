package it.t4group.androidsunflower.data

import androidx.room.Embedded
import androidx.room.Relation
import it.t4group.androidsunflower.data.gardenplanting.GardenPlanting
import it.t4group.androidsunflower.data.plants.Plant

class PlantAndGardenPlantings {

    @Embedded
    lateinit var plant: Plant

    @Relation(parentColumn="id", entityColumn="plantID")
    lateinit var gardenPlantings:List<GardenPlanting>

}