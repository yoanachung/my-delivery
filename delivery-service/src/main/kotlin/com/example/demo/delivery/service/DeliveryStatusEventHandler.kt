package com.example.demo.delivery.service

import com.example.demo.delivery.domain.DeliveryStatus
import com.example.demo.domainevent.AgencyDeliveryCanceledEvent
import com.example.demo.domainevent.AgencyDeliveryCompletedEvent
import com.example.demo.domainevent.AgencyDeliveryDepartedEvent
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
@Async
class DeliveryStatusEventHandler(
    private val deliveryService: DeliveryService,
) {
    @EventListener
    fun onAgencyDeliveryDepartedEvent(event: AgencyDeliveryDepartedEvent) {
        deliveryService.changeStatus(event.deliveryId, DeliveryStatus.DEPARTED)
    }

    @EventListener
    fun onAgencyDeliveryCompletedEvent(event: AgencyDeliveryCompletedEvent) {
        deliveryService.changeStatus(event.deliveryId, DeliveryStatus.COMPLETED)
    }

    @EventListener
    fun onAgencyDeliveryCanceledEvent(event: AgencyDeliveryCanceledEvent) {
        deliveryService.changeStatus(event.deliveryId, DeliveryStatus.CANCELED)
    }
}