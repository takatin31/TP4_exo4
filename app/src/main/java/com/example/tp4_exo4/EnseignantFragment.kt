package com.example.tp4_exo4

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.fragment_enseignant.*
import kotlinx.android.synthetic.main.fragment_module.*
import kotlinx.android.synthetic.main.fragment_module.sortirBtnView

class EnseignantFragment : Fragment() {

    lateinit var enseignant: Enseignant
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        enseignant = arguments?.getSerializable("prof") as Enseignant
        return inflater.inflate(R.layout.fragment_enseignant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nomTextView.text = enseignant.nom
        prenomTextView.text = enseignant.prenom
        emailTextView.text = enseignant.email
        numberTextView.text = enseignant.numero.toString()

        sortirBtnView.setOnClickListener {
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            val flouLayout = activity!!.findViewById<RelativeLayout>(R.id.flouLayout)
            flouLayout.visibility = View.INVISIBLE
            transaction.remove(this)
            transaction.commit()
        }
    }
}
