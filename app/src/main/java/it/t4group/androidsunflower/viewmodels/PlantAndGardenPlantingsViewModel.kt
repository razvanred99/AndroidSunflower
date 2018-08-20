package it.t4group.androidsunflower.viewmodels

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import it.t4group.androidsunflower.R
import it.t4group.androidsunflower.data.PlantAndGardenPlantings
import java.text.SimpleDateFormat
import java.util.*

class PlantAndGardenPlantingsViewModel(context: Context, plantings: PlantAndGardenPlantings) : ViewModel() {

    private val plant = checkNotNull(plantings.plant)
    private val gardenPlanting = plantings.gardenPlantings[0]

    private val dateFormat by lazy { SimpleDateFormat("MMM d, yyyy", Locale.ITALIAN) }
    private val plantDateString by lazy { dateFormat.format(gardenPlanting.plantDate.time) }
    private val waterDateString by lazy { dateFormat.format(gardenPlanting.lastWateringDate.time) }
    private val wateringPrefix by lazy {
        context.getString(
                R.string.watering_next_prefix,
                waterDateString
        )
    }

    private val wateringSuffix by lazy {
        context.resources.getQuantityString(
                R.plurals.watering_next_suffix,
                plant.wateringInterval,
                plant.wateringInterval
        )
    }

    val imageURL = ObservableField<String>(plant.imageUrl)

    val plantDate = ObservableField<String>(
            context.getString(
                    R.string.planted_date, plant.name,
                    plantDateString
            )
    )

    val waterDate = ObservableField<String>("$wateringPrefix - $wateringSuffix")

}