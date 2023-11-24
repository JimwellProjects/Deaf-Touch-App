package edu.ucu.cite.deaftouchapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import edu.ucu.cite.deaftouchapp.LearnCategoryPage.*

class LearnCategory : AppCompatActivity(), ItemAdapter.ClickedItem  {

    var navigationView: NavigationView? = null
    var mydrawer: DrawerLayout? = null
    var toolbar: Toolbar? = null
    var mytoggle: ActionBarDrawerToggle? = null


    var itemListModal = arrayOf(
        ItemModal(R.drawable.alpabhets, "Alphabets", "Basic Alphabets"),
        ItemModal(R.drawable.animal, "Animals", "Common Animals"),
        ItemModal(R.drawable.colors, "Colors", "Basic Colors"),
        ItemModal(R.drawable.emotion, "Emotions", "Basic Emotions"),
        ItemModal(R.drawable.everythingwedo, "Everything We Do", "Common Words"),
        ItemModal(R.drawable.familymember, "Family Member", "Family Members"),
        ItemModal(R.drawable.foods, "Foods", "Basic Foods"),
        ItemModal(R.drawable.greetings, "Greetings", "Simple Greeetings"),
        ItemModal(R.drawable.calendar, "Months", "Jan - Dec"),
        ItemModal(R.drawable.numbers, "Numbers", "1 - 10 Numbers"),
        ItemModal(R.drawable.bodyparts, "Parts Of The Body", "Basic Parts"),
        ItemModal(R.drawable.question, "Questions", "Basic Questions"),
            ItemModal(R.drawable.shapes, "Shapes", "Common Shapes"),
        ItemModal(R.drawable.thingsinhome, "Things In Home", "Basic Things In Home"),



        )
    var itemModalList = ArrayList<ItemModal>()

    var itemAdapter: ItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_category)

        for (item in itemListModal){
            itemModalList.add(item)
        }

        var recyclerView: RecyclerView
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        itemAdapter = ItemAdapter(this)
        itemAdapter!!.setData(itemModalList)
        recyclerView.adapter = itemAdapter

        var mydrawer: DrawerLayout
        var navigationView: NavigationView

        mydrawer = findViewById(R.id.mydrawer)
        navigationView = findViewById(R.id.navigationdrawer)

        toolbar = findViewById(R.id.sidetoolbar)
        mytoggle = ActionBarDrawerToggle(this, mydrawer, toolbar, R.string.open, R.string.close)

        mydrawer.addDrawerListener(mytoggle!!)
        navigationView.bringToFront()
        mytoggle!!.syncState()
        mytoggle!!.drawerArrowDrawable.color = resources.getColor(R.color.white)

        navigationView.itemIconTintList = null
        setSupportActionBar(toolbar)
    }


    override fun onBackPressed() {
        val drawerLayout = findViewById<View>(R.id.mydrawer) as DrawerLayout
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (mytoggle!!.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.LearnSidebar -> {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }
            R.id.VideosSidebar -> {
                startActivity(Intent(applicationContext, VideosPage::class.java))
                finish()
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }
            R.id.BasicASlSidebar -> {
                startActivity(Intent(applicationContext, LearnCategory::class.java))
                finish()
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }
            R.id.AboutSidebar -> {
                startActivity(Intent(applicationContext, AboutUsPage::class.java))
                finish()
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }
        }
        return true
    }

    fun BackButton(view: View?) {
        val i = Intent(this@LearnCategory, MainActivity::class.java)
        startActivity(i)
        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        finishAffinity()
    }

    override fun clickedItem(itemModal: ItemModal) {
        var itemModal1 = itemModal
        var name = itemModal1.name

        when(name){
            "Alphabets" -> {
                val i = Intent(this@LearnCategory, LearnCategory1Alphabets::class.java)
                startActivity(i)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)

            }
            "Numbers" -> {
                val i = Intent(this@LearnCategory, LearnCategory2Numbers::class.java)
                startActivity(i)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }

            "Greetings" -> {
                val i = Intent(this@LearnCategory, LearnCategory3Greetings::class.java)
                startActivity(i)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }
            "Emotions" -> {
                val i = Intent(this@LearnCategory, LearnCategory4Emotions::class.java)
                startActivity(i)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }
            "Colors" -> {
                val i = Intent(this@LearnCategory, LearnCategory5Colors::class.java)
                startActivity(i)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }

            "Animals" -> {
                val i = Intent(this@LearnCategory, LearnCategory6Animals::class.java)
                startActivity(i)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }

            "Foods" -> {
                val i = Intent(this@LearnCategory, LearnCategory7Foods::class.java)
                startActivity(i)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }

            "Everything We Do" -> {
                val i = Intent(this@LearnCategory, LearnCategory8EverythingWeDo::class.java)
                startActivity(i)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }

            "Months" -> {
                val i = Intent(this@LearnCategory, LearnCategory9Months::class.java)
                startActivity(i)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }

            "Questions" -> {
                val i = Intent(this@LearnCategory, LearnCategory10Questions::class.java)
                startActivity(i)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }

            "Parts Of The Body" -> {
                val i = Intent(this@LearnCategory, LearnCategory11PartsOfTheBody::class.java)
                startActivity(i)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }

            "Family Member" -> {
                val i = Intent(this@LearnCategory, LearnCategory12FamilyMembers::class.java)
                startActivity(i)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }

            "Things In Home" -> {
                val i = Intent(this@LearnCategory, LearnCategory13ThingsInHome::class.java)
                startActivity(i)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }

            "Shapes" -> {
                val i = Intent(this@LearnCategory, LearnCategory14Shapes::class.java)
                startActivity(i)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            }




            else -> {
                Toast.makeText(this@LearnCategory, "No Action", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        var searchView = findViewById<SearchView>(R.id.searchbar)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                searchView.clearFocus()
                return false

            }

            override fun onQueryTextChange(p0: String?): Boolean {

                itemAdapter!!.filter.filter(p0)
                return false
            }

        })

        return super.onCreateOptionsMenu(menu)
    }
}


