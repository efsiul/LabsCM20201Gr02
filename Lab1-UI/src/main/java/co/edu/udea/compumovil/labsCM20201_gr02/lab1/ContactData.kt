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


        findViewById<Button>(R.id.button_siguiente).setOnClickListener { agregaInfo(it) }

    }
    private fun agregaInfo(view: View?) {
        val editTextPhone = findViewById<EditText>(R.id.editTextPhone_Contact)
        val editTextEmail = findViewById<EditText>(R.id.editTextTextEmailAddress2)
        val autocompleteCountry=findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView    )
        val textPhone= editTextPhone.text
        val textEmail = editTextEmail.text
        val autoCompCountry=autocompleteCountry.text

        if (editTextPhone.text.toString().isNotEmpty() || editTextEmail.text.toString().isNotEmpty() || autocompleteCountry.text.toString().isNotEmpty()){
            Log.i("Telefono", "$textPhone $textEmail")

            Log.i("Nació en",autoCompCountry.toString())

        }else {
            Toast.makeText(this, "Debe ingresar campos obligatorios", Toast.LENGTH_SHORT).show()
            return}
        Toast.makeText(this, "Hecho!", Toast.LENGTH_SHORT).show()

    }


}