package co.edu.udea.compumovil.gr02_20201.lab2.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import co.edu.udea.compumovil.gr02_20201.lab2.EntidadesYDaos.UserDao
import co.edu.udea.compumovil.gr02_20201.lab2.EntidadesYDaos.User

@Database(entities = [User::class], version = 1)
abstract class LaboratorioDosDB : RoomDatabase(){
    abstract fun usuarioDao():UserDao
}