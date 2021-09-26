package com.example.demo.store.domain

import com.example.demo.vo.DeliveryFee
import com.example.demo.vo.Distance

class StoreDeliveryFees(
    val value: List<StoreDeliveryFee> = listOf()
) {
    fun deliveryFee(distance: Distance): DeliveryFee {
        return value
            .sorted()
            .first { it.fittedDistance(distance) }
            .deliveryFee
    }

    fun delete() {
        value.forEach { it.delete() }
    }

    companion object {
        fun empty(): StoreDeliveryFees {
            return StoreDeliveryFees()
        }
    }
}