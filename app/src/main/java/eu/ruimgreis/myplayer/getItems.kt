package eu.ruimgreis.myplayer

object MediaProvider {
    fun getItems(): List<MediaItem> {
        Thread.sleep(2000)
        return (1..10).map {
            MediaItem(
                it,
                "Title $it",
                "https://placekitten.com/200/200?image=$it",
                if (it % 3 == 0) Type.VIDEO else Type.PHOTO
            )
        }
    }
}

    /*
    listOf(
    MediaItem("Title 1", "https://placekitten.com/200/200?image=1", type = Type.PHOTO),
    MediaItem("Title 2", "https://placekitten.com/200/200?image=2", type = Type.PHOTO),
    MediaItem("Title 3", "https://placekitten.com/200/200?image=3", type = Type.VIDEO),
    MediaItem("Title 4", "https://placekitten.com/200/200?image=4", type = Type.PHOTO),
    MediaItem("Title 5", "https://placekitten.com/200/200?image=5", type = Type.PHOTO),
    MediaItem("Title 6", "https://placekitten.com/200/200?image=6", type = Type.VIDEO),
    MediaItem("Title 7", "https://placekitten.com/200/200?image=7", type = Type.PHOTO),
    MediaItem("Title 8", "https://placekitten.com/200/200?image=8", type = Type.PHOTO),
    MediaItem("Title 9", "https://placekitten.com/200/200?image=9", type = Type.PHOTO),
    MediaItem("Title 10", "https://placekitten.com/200/200?image=10", type = Type.VIDEO),
)

     */