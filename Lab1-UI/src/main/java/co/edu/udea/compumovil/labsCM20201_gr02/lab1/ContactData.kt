package co.edu.udea.compumovil.labsCM20201_gr02.lab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class ContactData : AppCompatActivity() {

    lateinit var Selector:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)


        findViewById<Button>(R.id.button_Finalizar).setOnClickListener { agregaInfo(it) }

    }
    private fun agregaInfo(view: View?) {
        val inputTextPhone = findViewById<EditText>(R.id.telefono)
        val inputTextEmail = findViewById<EditText>(R.id.email)
        val inputTextCountry=findViewById<AutoCompleteTextView>(R.id.pais    )
        val textPhone= inputTextPhone.text
        val textEmail = inputTextEmail.text
        val autoCompCountry=inputTextCountry.text

        if (inputTextPhone.text.toString().isNotEmpty() || inputTextEmail.text.toString().isNotEmpty()|| inputTextCountry.text.toString().isNotEmpty()){
            Log.i("Telefono", "$textPhone $textEmail")

            Log.i("Nació en",autoCompCountry.toString())

        }else {
            Toast.makeText(this, "Debe ingresar campos obligatorios", Toast.LENGTH_SHORT).show()
            return}
        Toast.makeText(this, "Hecho!", Toast.LENGTH_SHORT).show()

    }


}