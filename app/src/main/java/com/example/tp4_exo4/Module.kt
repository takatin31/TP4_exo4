package com.example.tp4_exo4

import java.io.Serializable

class Module(mIntitule : String, mDuree : Int, mEnseignant : Enseignant) : Serializable {
    var intitule = mIntitule
    var duree = mDuree
    var enseignant = mEnseignant
}