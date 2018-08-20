package it.t4group.androidsunflower.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import it.t4group.androidsunflower.data.gardenplanting.GardenPlanting
import it.t4group.androidsunflower.data.gardenplanting.GardenPlantingDao
import it.t4group.androidsunflower.data.plants.Plant
import it.t4group.androidsunflower.data.plants.PlantDao
import it.t4group.androidsunflower.workers.SeedDatabaseWorker

@Database(entities = [GardenPlanting::class, Plant::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gardenPlantingDao(): GardenPlantingDao
    abstract fun plantDao(): PlantDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context) =
                instance ?: synchronized(this) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context, AppDatabase::class.java, "AndroidSunflower")
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                                WorkManager.getInstance().enqueue(request)
                            }
                        }).build()

    }

}