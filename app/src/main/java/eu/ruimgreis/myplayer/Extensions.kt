package eu.ruimgreis.myplayer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

fun Context.toast(message: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, length).show()
}

fun RecyclerView.ViewHolder.toast(message: String, length: Int = Toast.LENGTH_LONG){
    itemView.context.toast(message, length)
}

//val view = LayoutInflater.from(parent.context).inflate(R.layout.view_media_item, parent, false)

fun ViewGroup.inflate(@LayoutRes layoutResource: Int): View {
    return LayoutInflater.from(this.context).inflate(layoutResource, this, false)
}


//Glide.with(binding.mediaThumb).load(mediaItem.thumbUrl).into(binding.mediaThumb)

fun ImageView.loadUrl(url: String){
    Glide.with(this).load(url).into(this)
}