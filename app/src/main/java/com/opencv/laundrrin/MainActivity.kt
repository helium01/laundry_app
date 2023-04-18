package com.opencv.laundrrin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.opencv.laundrrin.fragment.AkunFragment
import com.opencv.laundrrin.fragment.HomeFragment
import com.opencv.laundrrin.fragment.PaketLaundryFragment
import com.opencv.laundrrin.fragment.PemasukanFragment
import com.opencv.laundrrin.fragment.PembayaranFragment
import com.opencv.laundrrin.fragment.PetaFragment
import com.opencv.laundrrin.fragment.ProgressFragment

class MainActivity : AppCompatActivity() {

   private val FragmentHome : Fragment = HomeFragment()
    private val FragmentAkun : Fragment = AkunFragment()
    private val FragmentPaketLaundry : Fragment = PaketLaundryFragment()
    private val FragmentPemasukan : Fragment = PemasukanFragment()
    private val FragmentPembayaran : Fragment = PembayaranFragment()
    private val FragmentPeta : Fragment = PetaFragment()
    private val FragmentProgress : Fragment = ProgressFragment()
    private val fm :FragmentManager = supportFragmentManager
    private var active :Fragment = FragmentHome
    private lateinit var menu :Menu
    private lateinit var menuitem : MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setButtonNav()

    }
    fun setButtonNav(){
        fm.beginTransaction().add(R.id.container1,FragmentHome).show(FragmentHome).commit()
        fm.beginTransaction().add(R.id.container1,FragmentAkun).hide(FragmentAkun).commit()
        fm.beginTransaction().add(R.id.container1,FragmentPaketLaundry).hide(FragmentPaketLaundry).commit()
        fm.beginTransaction().add(R.id.container1,FragmentPemasukan).hide(FragmentPemasukan).commit()
        fm.beginTransaction().add(R.id.container1,FragmentPembayaran).hide(FragmentPembayaran).commit()
        fm.beginTransaction().add(R.id.container1,FragmentPeta).hide(FragmentPeta).commit()
        fm.beginTransaction().add(R.id.container1,FragmentProgress).hide(FragmentProgress).commit()

        bottomNavigationView=findViewById(R.id.nav_view)
        menu=bottomNavigationView.menu
        menuitem=menu.getItem(0)
        menuitem.isChecked=true

        bottomNavigationView.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.navigation_home->{
                    panggilfragment(0,FragmentHome)
                }
                R.id.navigation_paket->{
                    panggilfragment(1,FragmentPaketLaundry)
                }
                R.id.navigation_pembayaran->{
                    panggilfragment(2,FragmentPembayaran)
                }
                R.id.navigation_progres->{
                    panggilfragment(3,FragmentProgress)
                }
                R.id.navigation_user->{
                    panggilfragment(4,FragmentAkun)
                }
                R.id.navigation_peta->{
                    panggilfragment(5,FragmentPeta)
                }
                R.id.navigation_pemasukan->{
                    panggilfragment(6,FragmentPemasukan)
                }
            }

            false
        }
    }
    fun panggilfragment(int: Int,fragment: Fragment){
        menuitem=menu.getItem(int)
        menuitem.isChecked=true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}

