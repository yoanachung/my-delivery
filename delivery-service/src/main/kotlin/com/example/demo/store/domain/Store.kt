package com.example.demo.store.domain

import com.example.demo.agency.domain.DeliveryAgencyType
import com.example.demo.exception.DeliveryException
import com.example.demo.vo.Address

class Store(
    val storeId: Long,
    val address: Address,
    name: String,
) {
    var name: String = name
        protected set

    var storeDeliveryAgencies: StoreDeliveryAgencies = StoreDeliveryAgencies.empty()
        protected set

    fun updateName(name: String) {
        this.name = name
    }

    fun addDeliveryAgency(storeDeliveryAgency: StoreDeliveryAgency) {
        if (storeDeliveryAgencies.any(storeDeliveryAgency)) {
            throw DeliveryException("이미 등록되어 있는 배달업체입니다. ${storeDeliveryAgency.deliveryAgencyType}")
        }

        this.storeDeliveryAgencies = this.storeDeliveryAgencies + storeDeliveryAgency
    }

    fun updateDeliveryFees(deliveryAgencyType: DeliveryAgencyType, deliveryFees: StoreDeliveryFees) {
        val storeDeliveryAgency = this.storeDeliveryAgencies.storeDeliveryAgency(deliveryAgencyType)
        storeDeliveryAgency.updateDeliveryFees(deliveryFees)
    }
}