package hr.asseco.mbanking.dialogFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.password_dialog.view.*
import kotlinx.android.synthetic.main.password_dialog.view.DialogLogin
import android.content.Intent
import hr.asseco.mbanking.R
import hr.asseco.mbanking.TransactionActivity

class CustomDialogFragment() : DialogFragment(){

    lateinit var password: EditText
    val MIN_PASSWORD_LENGHT = 4
    val MAX_PASSWORD_LENGHT = 6

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.password_dialog, container, false)
        
        rootView.DialogLogin.setOnClickListener {
            if (!isPasswordValid(rootView.editNumberPassword.text.toString())){
                rootView.editNumberPassword.error = "Invalid password!"
            }else {
                val startTransactionIntent = Intent(this.activity, TransactionActivity::class.java)
                startActivity(startTransactionIntent)
            }
        }
        return rootView
    }

    fun isPasswordValid(password: String): Boolean {
        var valid: Boolean = false
        if (password.length >= MIN_PASSWORD_LENGHT && password.length <= MAX_PASSWORD_LENGHT){
            valid = true
        }
        return valid
    }

}
