package com.example.demo.vo

import kotlin.math.*

data class Coordinates(
    val latitude: Double,
    val longitude: Double,
) {
    fun distanceTo(to: Coordinates): Distance {
        val dLat = radius(latitude - to.latitude)
        val dLon = radius(longitude - to.longitude)

        val a = sin(dLat / 2) *
                sin(dLat / 2) +
                cos(radius(to.latitude)) *
                cos(radius(latitude)) *
                sin(dLon / 2) *
                sin(dLon / 2)

        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        val d = 6371 * c

        return Distance.roundedDown(d)
    }

    private fun radius(degree: Double): Double {
        return degree * PI / 180.0
    }
}
