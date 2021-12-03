package hr.asseco.mbanking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import hr.asseco.mbanking.dialogFragments.CustomDialogFragment

class MainActivity : AppCompatActivity() {

    val MAX_FIRST_NAME_LENGHT = 30
    val MAX_LAST_NAME_LENGHT = 30

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirstName.setOnClickListener{
            if (!isFirstNameValid(FirstName.text.toString())){
                FirstName.error = "First name has to be less than 30 characters!"
            }
        }

        LastName.setOnClickListener {
            if (!isLastNameValid(LastName.text.toString())){
                LastName.error = "Last name has to be less than 30 characters!"
            }
        }

        Login.setOnClickListener {
            if (!isFirstNameValid(FirstName.text.toString())){
                FirstName.error = "Invalid First Name"
            } else if (!isLastNameValid(LastName.text.toString())){
                LastName.error = "Invalid Last Name"
            }
            else {
                var dialog = CustomDialogFragment()
                dialog.show(supportFragmentManager, "customDialog")

            }
        }

    }

    //treba dodat provjeru dal su alfanumericki znakovi!!!
    private fun isLastNameValid(lastName: String): Boolean {
        if (lastName == "" || !isAlphanumeric(lastName)){
            LastName.error = "Last name required!"
            return false
        }
        return lastName.length < MAX_LAST_NAME_LENGHT
    }

    private fun isFirstNameValid(firstName: String): Boolean {
        if (firstName == "" || !isAlphanumeric(firstName)){
            FirstName.error = "First name required!"
            return false
        }
        return firstName.length < MAX_FIRST_NAME_LENGHT
    }

    private fun isAlphanumeric(chars : String) : Boolean{
        return chars.matches("^[a-zA-Z0-9ćčđšž]*$".toRegex())
    }
}