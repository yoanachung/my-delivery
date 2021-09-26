package com.example.demo.vo

import com.example.demo.exception.DeliveryException

data class DeliveryFee(
    val value: Int
) : Comparable<DeliveryFee> {
    init {
        if (value < 0) {
            throw DeliveryException("배송비가 올바르지 않습니다.")
        }
    }

    override fun compareTo(other: DeliveryFee): Int {
        return value.compareTo(other.value)
    }
}