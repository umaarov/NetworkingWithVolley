package uz.umarov.google_sheets_tut

import android.app.VoiceInteractor.Request
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import uz.umarov.google_sheets_tut.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveData.setOnClickListener {

            val name = binding.name.text.toString()
            val surname = binding.surname.text.toString()
            val age = binding.age.text.toString()

            saveData(name, surname, age)

        }
    }

    private fun saveData(name: String, surname: String, age: String) {

        var url =
            "https://script.google.com/macros/s/AKfycbyaWI1pfS1dAWIhNYdpYKl8vxV15WpedWMBq4NKFOIrdO-Bl7V-9-T4kh3a4IsBRjuv/exec?"

        url = url + "action=create&name=" + name + "&surname=" + surname + "&age=" + age;

        val stringRequest =
            object : StringRequest(Method.GET, url, Response.Listener { response ->
                Toast.makeText(this, response, Toast.LENGTH_SHORT).show()
            }, Response.ErrorListener {
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
            }) {


            }

        val queue = Volley.newRequestQueue(this)
        queue.add(stringRequest)

    }
}