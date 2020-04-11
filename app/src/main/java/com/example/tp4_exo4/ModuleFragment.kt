package com.example.tp4_exo4

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_module.*
import java.io.Serializable

class ModuleFragment : Fragment() {

    lateinit var module : Module
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        module = arguments?.getSerializable("module") as Module
        return inflater.inflate(R.layout.fragment_module, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moduleNameView.text = module.intitule
        dureeView.text = module.duree.toString()+" H"
        enseignantBtnView.text = module.enseignant.nom

        sortirBtnView.setOnClickListener {
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            val flouLayout = activity!!.findViewById<RelativeLayout>(R.id.flouLayout)
            flouLayout.visibility = View.INVISIBLE
            transaction.remove(this)
            transaction.commit()
        }

        enseignantBtnView.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("prof", module.enseignant as Serializable)

            val transaction = activity!!.supportFragmentManager.beginTransaction()
            val frag2 = EnseignantFragment()
            frag2.arguments = bundle

            transaction.replace(R.id.frameLayout, frag2)
            transaction.addToBackStack(null)
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            transaction.commit()
        }

    }

    }
