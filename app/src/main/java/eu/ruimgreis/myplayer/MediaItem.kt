package eu.ruimgreis.myplayer

enum class Type { PHOTO , VIDEO }

data class MediaItem (val title: String, val thumbUrl: String, val type: Type)
