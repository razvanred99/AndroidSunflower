package it.t4group.androidsunflower.workers

import androidx.work.Worker

class SeedDatabaseWorker: Worker(){

    override fun doWork():Worker.Result{
        return Result.SUCCESS
    }

}