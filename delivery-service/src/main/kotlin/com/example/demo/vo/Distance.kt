package com.example.demo.vo

import com.example.demo.exception.DeliveryException
import kotlin.math.floor

data class Distance(
    val value: Double
) : Comparable<Distance> {
    init {
        if (value < 0) {
            throw DeliveryException("거리가 올바르지 않습니다.")
        }
    }

    override fun compareTo(other: Distance): Int {
        return value.compareTo(other.value)
    }

    fun closerThanOrEqual(other: Distance): Boolean {
        return compareTo(other) <= 0
    }

    fun fartherThanOrEqual(other: Distance): Boolean {
        return compareTo(other) >= 0
    }

    companion object {
        private const val DECIMAL_PLACES = 10.0

        fun roundedDown(value: Double): Distance {
            return Distance(floor(value * DECIMAL_PLACES) / DECIMAL_PLACES)
        }
    }
}