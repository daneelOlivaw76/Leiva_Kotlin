package eu.ruimgreis.myplayer

sealed class Filter {
    object None: Filter()
    class ByType(val type: Type): Filter()
}