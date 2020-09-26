package co.edu.udea.compumovil.labsCM20201_gr02.lab1

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_personal_data.*
import java.util.*

class PersonalData : AppCompatActivity() {

    lateinit var seleccion:Spinner
    lateinit var resultado:String
    var fechaLog = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)
        spinnerEstudio()
        findViewById<Button>(R.id.button_siguiente).setOnClickListener { agregaInfo(it) }
    }

    private fun agregaInfo(view: View){
        val inputTextNombre = findViewById<EditText>(R.id.inputText_nombre)
        val inputTextApellido = findViewById<EditText>(R.id.inputText_apellido)
        val textNombre = inputTextNombre.text
        val textApellido = inputTextApellido.text
        /*val textoPrueba = findViewById<TextView>(R.id.texto_prueba)
        val textoPruebados = findViewById<TextView>(R.id.texto_prueba2)
        textoPrueba.text = inputTextNombre.text
        textoPruebados.text = inputTextApellido.text*/
        if (fechaLog != "empty" || inputTextNombre.text.toString().isNotEmpty() || inputTextApellido.text.toString().isNotEmpty()){
            Log.i("Nombre", textNombre.toString() +" "+ textApellido.toString() )
            selecSexo()
            Log.i("Nació el",fechaLog.toString())
            if(resultado != "Grado de escolaridad"){
                Log.i("Escolaridad", resultado)
            }
            siguienteActividad()
        }else {
            Toast.makeText(this, "Debe ingresar campos obligatorios", Toast.LENGTH_SHORT).show()
            return}
        Toast.makeText(this, "Hecho!", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n")
    fun muestraFecha(view: View){
        val cal = Calendar.getInstance()
        val dia = cal.get(Calendar.DAY_OF_MONTH)
        val mes = cal.get(Calendar.MONTH)
        val year = cal.get(Calendar.YEAR)
        val picker = DatePickerDialog(this, android.R.style.Theme_DeviceDefault, DatePickerDialog.OnDateSetListener { view : DatePicker, ano:Int, mesAnoMalo:Int, diaMes:Int ->
            val mesAno = mesAnoMalo + 1
            val fecha = "$diaMes/$mesAno/$ano"
            editTextDate.text = fecha
            fechaLog = fecha
        }, year, mes, dia)
        picker.show()
    }

    fun spinnerEstudio(){
        seleccion = findViewById(R.id.spinner_estudio) as Spinner
        //resultado = findViewById(R.id.textViewSpinner) as TextView
        val opciones = arrayOf("Grado de escolaridad","Primaria","Secundaria","Universitaria", "Otro")
        seleccion.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opciones)

        seleccion.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                resultado = opciones.get(p2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    fun selecSexo(){
        val hombre = radio_hombre.isChecked
        val mujer = radio_mujer.isChecked
        if (hombre || mujer){
            if (hombre){
                Log.i("-","Masculino")
            }else Log.i("-","Femenino")
        }
    }

    fun siguienteActividad(){
        val intent : Intent = Intent(this, DummyActivity::class.java)
        startActivity(intent)
    }
}