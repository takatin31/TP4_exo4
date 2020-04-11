package com.example.tp4_exo4

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var listeEnseignant : MutableList<Enseignant> = ArrayList()
    var listeModules : MutableList<Module> = ArrayList()
    var listSeance : MutableList<Seance> = ArrayList()

    lateinit var adapter: SeanceAdapter
    lateinit var layoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initEnseignants()
        initModule()
        initSeances()

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = SeanceAdapter(this)
        recyclerView.adapter = adapter
    }

    fun initEnseignants() {
        var enseignant1 = Enseignant("MOSTEFAI", "Mohamed Amine", "m_mostefai@esi.dz", 70000000)
        var enseignant2 = Enseignant("BATATA", "Sofiane", "s_batata@esi.dz", 70000000)
        var enseignant3 = Enseignant("Harkat", "Kamel", "k_harkat@esi.dz", 70000000)
        var enseignant4 = Enseignant("AZOUAOU", "Faical", "f_azouaou@esi.dz", 70000000)
        var enseignant5 = Enseignant("CHALAL", "Rachid", "r_chalal@esi.dz", 70000000)

        listeEnseignant.add(enseignant1)
        listeEnseignant.add(enseignant2)
        listeEnseignant.add(enseignant3)
        listeEnseignant.add(enseignant4)
        listeEnseignant.add(enseignant5)

    }

    fun initModule() {
        var module1 = Module("TDM1", 20, listeEnseignant.get(0))
        var module2 = Module("TDM2", 20, listeEnseignant.get(1))
        var module3 = Module("Projet", 40, listeEnseignant.get(2))
        var module4 = Module("MCSI", 45, listeEnseignant.get(3))
        var module5 = Module("IPLS", 42, listeEnseignant.get(4))
        var module6 = Module("Magil", 50, listeEnseignant.get(0))
        var module7 = Module("IGL", 50, listeEnseignant.get(1))
        var module8 = Module("Projet2", 35, listeEnseignant.get(2))
        var module9 = Module("Orga", 22, listeEnseignant.get(3))
        var module10 = Module("Securite", 25, listeEnseignant.get(4))

        listeModules.add(module1)
        listeModules.add(module2)
        listeModules.add(module3)
        listeModules.add(module4)
        listeModules.add(module5)
        listeModules.add(module6)
        listeModules.add(module7)
        listeModules.add(module8)
        listeModules.add(module9)
        listeModules.add(module10)

    }


    fun initSeances(){
        var seance1 = Seance("TD", listeModules[1], "08", "30", "10", "00")
        var seance2 = Seance("Cours", listeModules[2], "10", "00", "12", "00")
        var seance3 = Seance("TP", listeModules[3], "13", "00", "15", "00")
        var seance4 = Seance("TD", listeModules[4], "15", "10", "17", "00")
        var seance5 = Seance("TD", listeModules[5], "09", "00", "10", "30")
        var seance6 = Seance("Cours", listeModules[6], "10", "30", "12", "10")
        var seance7 = Seance("TD", listeModules[7], "08", "30", "10", "00")
        var seance8 = Seance("TD", listeModules[8], "15", "00", "16", "40")
        var seance9 = Seance("TP", listeModules[9],"08", "30", "10", "00")
        var seance10 = Seance("Cours", listeModules[0],"08", "30", "10", "00")
        var seance11 = Seance("Cours", listeModules[1], "10", "30", "12", "10")
        var seance12 = Seance("Cours", listeModules[3],"13", "00", "15", "00")
        var seance13 = Seance("TD", listeModules[4],"15", "00", "16", "40")
        var seance14 = Seance("Cours", listeModules[2],"08", "30", "10", "00")
        var seance15 = Seance("TP", listeModules[7],"10", "00", "12", "00")
        var seance16 = Seance("Cours", listeModules[8],"13", "00", "15", "00")
        var seance17 = Seance("TD", listeModules[5],"15", "10", "17", "00")
        var seance18 = Seance("Cours", listeModules[6],"10", "00", "12", "00")

        listSeance.add(seance1)
        listSeance.add(seance2)
        listSeance.add(seance3)
        listSeance.add(seance4)
        listSeance.add(seance5)
        listSeance.add(seance6)
        listSeance.add(seance7)
        listSeance.add(seance8)
        listSeance.add(seance9)
        listSeance.add(seance10)
        listSeance.add(seance11)
        listSeance.add(seance12)
        listSeance.add(seance13)
        listSeance.add(seance14)
        listSeance.add(seance15)
        listSeance.add(seance16)
        listSeance.add(seance17)
        listSeance.add(seance18)



    }



    class SeanceAdapter(val activity : MainActivity) : RecyclerView.Adapter<SeanceAdapter.TachViewHolder>(){
        class TachViewHolder(v : View) : RecyclerView.ViewHolder(v){
            val textViewSeance = v.findViewById<TextView>(R.id.seanceView)
            val textViewTime = v.findViewById<TextView>(R.id.timeSeance)
            val seanceLayout = v.findViewById<RelativeLayout>(R.id.seanceLayout)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TachViewHolder {
            return TachViewHolder(LayoutInflater.from(activity).inflate(R.layout.seance_layout, parent, false))
        }

        override fun getItemCount(): Int {
            return activity.listSeance.size
        }

        override fun onBindViewHolder(holder: TachViewHolder, position: Int) {
            holder.textViewSeance.text = activity.listSeance[position].getDescription()
            holder.textViewTime.text = activity.listSeance[position].getTime()
            val isLandscape = activity.getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE

            if (isLandscape){
                holder.seanceLayout.setOnClickListener {

                    val bundle = Bundle()
                    bundle.putInt("seanceIndex",position)
                    bundle.putSerializable("module", activity.listSeance[position].module as Serializable)

                    val transaction = activity.supportFragmentManager.beginTransaction()
                    val modFrag = ModuleFragment()

                    modFrag.arguments = bundle
                    transaction.replace(R.id.moduleFragment, modFrag)
                    transaction.addToBackStack(null)
                    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    transaction.commit()

                    val bundle2 = Bundle()
                    bundle2.putInt("seanceIndex",position)
                    bundle2.putSerializable("prof", activity.listSeance[position].module.enseignant as Serializable)

                    val transaction2 = activity.supportFragmentManager.beginTransaction()
                    val ensFrag = EnseignantFragment()
                    ensFrag.arguments = bundle2
                    transaction2.replace(R.id.enseignantFragment, ensFrag)
                    transaction2.addToBackStack(null)
                    transaction2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    transaction2.commit()
                }
            }else{
                holder.seanceLayout.setOnClickListener {

                    val flouLayout = activity.findViewById<RelativeLayout>(R.id.flouLayout)
                    flouLayout.visibility = View.VISIBLE

                    val bundle = Bundle()
                    bundle.putInt("seanceIndex",position)
                    bundle.putSerializable("module", activity.listSeance[position].module as Serializable)

                    val transaction = activity.supportFragmentManager.beginTransaction()
                    val frag2 = ModuleFragment()
                    frag2.arguments = bundle

                    transaction.replace(R.id.frameLayout, frag2)
                    transaction.addToBackStack(null)
                    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    transaction.commit()
                }
            }

        }
    }
}
