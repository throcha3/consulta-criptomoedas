package br.com.thiagopgr.cryptocurrency

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.thiagopgr.cryptocurrency.adapters.CurrencyListAdapter
import br.com.thiagopgr.cryptocurrency.constants.API_CONST_KEY.API_KEY
import br.com.thiagopgr.cryptocurrency.entities.CryptoCurrency.CurrencyEntity
import br.com.thiagopgr.cryptocurrency.entities.CryptoCurrency.DataEntity
import br.com.thiagopgr.cryptocurrency.retrofit.RetrofitInitializer
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.os.StrictMode


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private var mApiToken = API_KEY
    private lateinit var mProgressDialog : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->

        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        mProgressDialog = ProgressDialog.show(this, "Wait.",
            "Processing..!", true)

        //listCurrencies()
        getCurrencies()

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


    fun getCurrencies(){

        val call = RetrofitInitializer().currencyService().list(mApiToken)
        call.enqueue(object : Callback<CurrencyEntity> {
            override fun onResponse(call: Call<CurrencyEntity>?,
                                    response: Response<CurrencyEntity>?) {
                if (response?.code() == 401){
                    Toast.makeText(this@MainActivity, "Error!!", Toast.LENGTH_LONG).show()
                } else {
                    response?.body()?.let {
                        val data: CurrencyEntity = it
                        configureList(data)
                    }
                }
            }
            override fun onFailure(call: Call<CurrencyEntity>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }

    fun configureList(dataC: CurrencyEntity){

        var listValues = mutableListOf<DataEntity>()
        for (x in dataC.data){

            Log.e("crypto-id", x.id.toString())

            val callx = RetrofitInitializer().currencyService().info(mApiToken, x.id.toString())
            val info = callx.execute().body()

            if (info != null) {
                val logo = info.data.getValue(key = x.id.toString()).logo
                if (logo != null){
                    x.info = logo
                }
            }

            listValues.add(x)
        }
        rv_cryptolist.adapter = CurrencyListAdapter(listValues)
        // 3 - layout
        rv_cryptolist.layoutManager = LinearLayoutManager(this@MainActivity)

        mProgressDialog.dismiss()
    }
}
