package com.example.demo.store.domain

import com.example.demo.agency.domain.DeliveryAgencyType
import com.example.demo.exception.DeliveryException
import com.example.demo.vo.DeliveryFee
import com.example.demo.vo.Distance

class StoreDeliveryAgency(
    val storeId: Long,
    val deliveryAgencyType: DeliveryAgencyType,
) {
    var id: Long? = null
        protected set

    var deliveryFees: StoreDeliveryFees = StoreDeliveryFees.empty()
        protected set

    var active: Boolean = false
        protected set

    fun deliveryFee(distance: Distance): DeliveryFee {
        if (!active) {
            throw DeliveryException("배달 방법이 비활성화 상태입니다.")
        }

        return deliveryFees.deliveryFee(distance)
    }

    fun updateDeliveryFees(deliveryFees: StoreDeliveryFees) {
        this.deliveryFees.delete()
        this.deliveryFees = deliveryFees
    }
}