package com.example.demo.delivery.service

import com.example.demo.delivery.domain.*
import com.example.demo.delivery.repo.DeliveryRepository
import com.example.demo.delivery.service.dto.CreateDeliveryRequest
import com.example.demo.delivery.service.dto.CreateDeliveryResponse
import com.example.demo.store.repo.StoreRepository
import org.springframework.stereotype.Service

@Service
class DeliveryService(
    private val storeRepository: StoreRepository,
    private val deliveryRepository: DeliveryRepository,
) {
    fun create(request: CreateDeliveryRequest): CreateDeliveryResponse {
        val store = storeRepository.findByStoreId(request.storeId)

        val delivery = Delivery(
            orderId = request.orderId,
            deliveryProduct = DeliveryProduct(request.totalPrice, request.productsName),
            sender = Sender(store.storeId, store.address),
            receiver = Receiver(request.userId, request.receiverAddress),
        )

        deliveryRepository.save(delivery)
        return CreateDeliveryResponse(delivery)
    }

    fun changeStatus(deliveryId: Long, status: DeliveryStatus) {
        val delivery = deliveryRepository.findById(deliveryId)

        delivery.changeStatus(status)
    }
}