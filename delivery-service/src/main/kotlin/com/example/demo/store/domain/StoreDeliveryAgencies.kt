package com.example.demo.store.domain

import com.example.demo.agency.domain.DeliveryAgencyType

class StoreDeliveryAgencies(
    val value: List<StoreDeliveryAgency> = listOf()
) {
    operator fun get(index: Int): StoreDeliveryAgency {
        return value[index]
    }

    operator fun plus(other: StoreDeliveryAgency): StoreDeliveryAgencies {
        return StoreDeliveryAgencies(value + other)
    }

    fun size(): Int {
        return value.size
    }

    fun any(storeDeliveryAgency: StoreDeliveryAgency): Boolean {
        return value.any { it.deliveryAgencyType == storeDeliveryAgency.deliveryAgencyType }
    }

    fun storeDeliveryAgency(deliveryAgencyType: DeliveryAgencyType): StoreDeliveryAgency {
        return value.first { it.deliveryAgencyType == deliveryAgencyType }
    }

    companion object {
        fun empty(): StoreDeliveryAgencies {
            return StoreDeliveryAgencies()
        }
    }
}