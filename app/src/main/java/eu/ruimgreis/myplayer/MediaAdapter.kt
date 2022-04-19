package eu.ruimgreis.myplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import eu.ruimgreis.myplayer.databinding.ViewMediaItemBinding

class MediaAdapter(private val items: List<MediaItem>): Adapter<MediaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.view_media_item))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ViewMediaItemBinding.bind(view)
        fun bind(mediaItem: MediaItem){
            with(binding) {
                mediaTitle.text = mediaItem.title
                mediaThumb.loadUrl(mediaItem.thumbUrl)
                mediaVideoIndicator.visibility = when(mediaItem.type) {
                    Type.PHOTO -> View.INVISIBLE
                    Type.VIDEO -> View.VISIBLE
                }
            }
        }
    }
}