package com.example.demo.delivery.service.dto

import com.example.demo.vo.Address
import com.example.demo.vo.Coordinates

data class CreateDeliveryRequest(
    val orderId: String,
    val storeId: Long,
    val userId: Long,
    val totalPrice: Long,
    val productsName: String,
    val receiverTel: String,
    val dropRoadAddress: String,
    val dropDetailAddress: String,
    val dropLatitude: Double,
    val dropLongitude: Double,
    val dropZipcode: String,
) {
    val receiverAddress: Address by lazy {
        val coordinates = Coordinates(
            latitude = dropLatitude,
            longitude = dropLongitude,
        )

        Address(
            roadAddress = dropRoadAddress,
            detailAddress = dropDetailAddress,
            zipcode = dropZipcode,
            coordinates = coordinates,
        )
    }
}
