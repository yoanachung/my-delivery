package com.example.demo.delivery.service.dto

import com.example.demo.delivery.domain.Delivery

class CreateDeliveryResponse(
    val deliveryId: Long,
) {
    constructor(delivery: Delivery) : this(
        deliveryId = delivery.id!!,
    )
}
