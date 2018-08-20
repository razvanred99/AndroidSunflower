package it.t4group.androidsunflower.data

import androidx.room.TypeConverter
import java.util.*

class Converters {

    @TypeConverter
    fun calendarToDatestamp(calendar: Calendar) = calendar.timeInMillis

    @TypeConverter
    fun datestampToCalendar(value: Long) = Calendar.getInstance().apply { timeInMillis = value }

}