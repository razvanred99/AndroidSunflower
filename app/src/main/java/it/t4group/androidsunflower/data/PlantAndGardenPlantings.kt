package it.t4group.androidsunflower.data

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation
import it.t4group.androidsunflower.data.gardenplanting.GardenPlanting
import it.t4group.androidsunflower.data.plants.Plant

class PlantAndGardenPlantings {

    @Embedded
    lateinit var plant: Plant

    @Relation(parentColumn="id", entityColumn="plantID")
    lateinit var gardenPlantings:List<GardenPlanting>

}