package com.example.demo.agency.infra.selfdelivery

import com.example.demo.agency.service.AgencyService
import com.example.demo.delivery.domain.Delivery
import org.springframework.stereotype.Service

@Service
class SelfDeliveryService : AgencyService {
    override fun send(delivery: Delivery) {
        // do nothing
    }
}