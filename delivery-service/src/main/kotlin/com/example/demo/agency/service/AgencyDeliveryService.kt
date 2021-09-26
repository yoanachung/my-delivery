package com.example.demo.agency.service

import com.example.demo.agency.domain.AgencyDelivery
import com.example.demo.agency.domain.DeliveryAgencyType
import com.example.demo.domainevent.AgencyDeliveryCanceledEvent
import com.example.demo.domainevent.AgencyDeliveryCompletedEvent
import com.example.demo.domainevent.AgencyDeliveryDepartedEvent
import com.example.demo.agency.repo.AgencyDeliveryRepository
import com.example.demo.delivery.domain.Delivery
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class AgencyDeliveryService(
    private val agencyServiceFactory: AgencyServiceFactory,
    private val agencyDeliveryRepository: AgencyDeliveryRepository,
    private val eventPublisher: ApplicationEventPublisher,
) {
    fun send(delivery: Delivery, deliveryAgencyType: DeliveryAgencyType) {
        create(delivery, deliveryAgencyType)

        val service = agencyServiceFactory.service(deliveryAgencyType)
        service.send(delivery)
    }

    private fun create(delivery: Delivery, deliveryAgencyType: DeliveryAgencyType) {
        val agencyDelivery = AgencyDelivery(
            deliveryId = delivery.id!!,
            type = deliveryAgencyType,
        )

        agencyDeliveryRepository.save(agencyDelivery)
    }

    fun depart(agencyDeliveryId: Long) {
        val agencyDelivery = agencyDeliveryRepository.findById(agencyDeliveryId)

        agencyDelivery.depart()

        eventPublisher.publishEvent(AgencyDeliveryDepartedEvent(agencyDelivery.deliveryId))
    }

    fun complete(agencyDeliveryId: Long) {
        val agencyDelivery = agencyDeliveryRepository.findById(agencyDeliveryId)

        agencyDelivery.complete()

        eventPublisher.publishEvent(AgencyDeliveryCompletedEvent(agencyDelivery.deliveryId))
    }

    fun cancel(agencyDeliveryId: Long) {
        val agencyDelivery = agencyDeliveryRepository.findById(agencyDeliveryId)

        agencyDelivery.cancel()

        eventPublisher.publishEvent(AgencyDeliveryCanceledEvent(agencyDelivery.deliveryId))
    }
}