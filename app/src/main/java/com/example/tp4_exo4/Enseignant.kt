package com.example.tp4_exo4

import java.io.Serializable

class Enseignant (mNom : String, mPrenom : String, mEmail : String, mNumero : Long): Serializable{
    var nom = mNom
    var prenom = mPrenom
    var email = mEmail
    var numero = mNumero
}
