package com.example.demo.store.service.dto

import com.example.demo.agency.domain.DeliveryAgencyType

class UpdateDeliveryFeesRequest(
    val storeId: Long,
    val deliveryAgencyType: DeliveryAgencyType,
    val deliveryFees: List<DeliveryFee>,
) {
    class DeliveryFee(
        val deliveryFee: Int,
        val minDistance: Double,
        val maxDistance: Double,
    )
}
