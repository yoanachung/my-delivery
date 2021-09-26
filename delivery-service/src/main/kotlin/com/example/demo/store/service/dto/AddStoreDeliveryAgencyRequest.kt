package com.example.demo.store.service.dto

import com.example.demo.agency.domain.DeliveryAgencyType

class AddStoreDeliveryAgencyRequest(
    val storeId: Long,
    val deliveryAgencyType: DeliveryAgencyType,
)
