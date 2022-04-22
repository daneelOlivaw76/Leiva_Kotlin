package eu.ruimgreis.myplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.lifecycle.lifecycleScope
import eu.ruimgreis.myplayer.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), Logger {

    private lateinit var binding: ActivityMainBinding
    private val adapter = MediaAdapter {
        startActivity<DetailActivity>(DetailActivity.EXTRA_ID to it.id)
    }
    override val tag = "[TAG][MY_TAG]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        d("onCreate started")

        binding.recycler.adapter = adapter

        updateItems()

        d("onCreate finished")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun updateItems(filter: Filter = Filter.None) {

        lifecycleScope.launch(Dispatchers.Main) {
            binding.progress.visibility = View.VISIBLE

            val items = withContext(Dispatchers.IO) { MediaProvider.getItems() }

            adapter.items = when(filter) {
                is Filter.ByType -> items.filter { it.type == filter.type }
                Filter.None -> items
            }

            binding.progress.visibility = View.GONE
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val filter = when(item.itemId) {
            R.id.filter_photos -> Filter.ByType(Type.PHOTO)
            R.id.filter_videos -> Filter.ByType(Type.VIDEO)
            else -> { Filter.None }
        }
        updateItems(filter)
        return super.onOptionsItemSelected(item)
    }
}


