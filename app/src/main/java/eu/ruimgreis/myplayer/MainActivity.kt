package eu.ruimgreis.myplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import eu.ruimgreis.myplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Logger {

    private lateinit var binding: ActivityMainBinding
    override val tag = "[TAG][MY_TAG]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        d("onCreate started")

        binding.recycler.adapter = MediaAdapter(getItems())

        d("onCreate finished")
    }

}