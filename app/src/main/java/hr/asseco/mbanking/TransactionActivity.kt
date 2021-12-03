package hr.asseco.mbanking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import hr.asseco.mbanking.adapters.TransactionAdapter
import hr.asseco.mbanking.dialogFragments.AccountsDialogFragment
import kotlinx.android.synthetic.main.activity_transaction.*
import hr.asseco.mbanking.models.*
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset

class TransactionActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Navigation Menu clicked", Toast.LENGTH_SHORT).show()
        }

        IBANField.setOnClickListener {
            var AccountDialog = AccountsDialogFragment()
            AccountDialog.show(supportFragmentManager, "customDialog")
        }

        try {
            val jsonString = getJSONFormAssets()!!
            val users = Gson().fromJson(jsonString, Accounts::class.java)

            transactionRecycle.layoutManager = LinearLayoutManager(this)
            val itemAdapter = TransactionAdapter(this, users.transactions)
            transactionRecycle.adapter = itemAdapter
        } catch (e: JSONException){
            e.printStackTrace()
        }catch (e: NullPointerException){
            e.printStackTrace()
        }
        
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemview = item.itemId

        when(itemview){
            R.id.Logout -> {
                val logoutIntent = Intent(this, MainActivity::class.java)
                startActivity(logoutIntent)
            }
        }
        return false
    }

    private fun getJSONFormAssets(): String? {

        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile = assets.open("Zadatak_1.json")
            val size = myUsersJSONFile.available()
            val buffer = ByteArray(size)
            myUsersJSONFile.read(buffer)
            myUsersJSONFile.close()
            json = String(buffer, charset)
        } catch (e: IOException){
            e.printStackTrace()
            return  null
        }
        return json

    }
}