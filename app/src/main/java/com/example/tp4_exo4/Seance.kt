package com.example.tp4_exo4

class Seance(mNom : String, mModule : Module, tHourDebut : String, tMinuteDebut : String , tHourEnd : String, tMinuteEnd : String) {
    var nom = mNom
    var module = mModule
    var hourDebut = tHourDebut
    var minuteDebut = tMinuteDebut
    var hourEnd = tHourEnd
    var minuteEnd = tMinuteEnd

    fun getDescription() : String{
        return "$nom ${module.intitule}"
    }

    fun getTime() : String{
        return "$hourDebut:$minuteDebut-$hourEnd:$minuteEnd"
    }
}
