package dev.falcer.telegramf.data

data class OnBoard(
    var title: String?,
    var description: String?,
    var startAnimateFrom: Int?,
    var endAnimateFrom: Int?,
    var isReverseAnimate: Boolean = true
)