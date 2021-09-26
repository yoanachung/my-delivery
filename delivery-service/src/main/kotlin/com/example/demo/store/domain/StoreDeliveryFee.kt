package com.example.demo.store.domain

import com.example.demo.vo.DeliveryFee
import com.example.demo.vo.Distance

class StoreDeliveryFee(
    val deliveryFee: DeliveryFee,
    val minDistance: Distance,
    val maxDistance: Distance,
) : Comparable<StoreDeliveryFee> {
    var id: Long? = null
        protected set

    var deleted: Boolean = false
        protected set

    fun fittedDistance(distance: Distance): Boolean {
        return distance.fartherThanOrEqual(minDistance) && distance.closerThanOrEqual(maxDistance)
    }

    override fun compareTo(other: StoreDeliveryFee): Int {
        val i = minDistance.compareTo(other.minDistance)

        if (i != 0) {
            return i
        }

        return deliveryFee.compareTo(other.deliveryFee)
    }

    fun delete() {
        this.deleted = true
    }
}