package org.d3if3163.mobpro2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3163.mobpro2.model.Mahasiswa

@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class MahasiswaDb: RoomDatabase() {

    abstract val dao:MahasiswaDao

    companion object{
        @Volatile
        private var INSTANCE: MahasiswaDb? = null

        fun getInstance(context: Context):MahasiswaDb{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MahasiswaDb::class.java,
                        "mahasiswa.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
