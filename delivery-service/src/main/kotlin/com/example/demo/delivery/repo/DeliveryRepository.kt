package com.example.demo.delivery.repo

import com.example.demo.delivery.domain.Delivery
import org.springframework.stereotype.Repository

@Repository
interface DeliveryRepository {
    fun save(delivery: Delivery)
    fun findById(deliveryId: Long): Delivery
}