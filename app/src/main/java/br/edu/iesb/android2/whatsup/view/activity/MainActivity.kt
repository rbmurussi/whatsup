package br.edu.iesb.android2.whatsup.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.edu.iesb.android2.whatsup.R
import br.edu.iesb.android2.whatsup.view.fragment.MainFragment
import br.edu.iesb.android2.whatsup.view.fragment.MapsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initHomeFragment()
        initBottonNavigation()
    }

    private fun initHomeFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MainFragment()).commit()
    }

    private fun initBottonNavigation() {
        bottom_navigation_icon.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragment : Fragment = when(item.itemId) {
            R.id.nav_home -> MainFragment()
            R.id.nav_chat -> MainFragment()
            R.id.nav_map -> MapsFragment()
            else -> MainFragment()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment).commit()
        return true
    }

}