package com.example.demo.agency.service

import com.example.demo.agency.domain.DeliveryAgencyType
import com.example.demo.agency.infra.samplecompany.SampleCompanyService
import com.example.demo.agency.infra.selfdelivery.SelfDeliveryService
import org.springframework.stereotype.Service

@Service
class AgencyServiceFactory(
    private val sampleCompanyService: SampleCompanyService,
    private val selfDeliveryService: SelfDeliveryService,
) {
    fun service(deliveryAgencyType: DeliveryAgencyType) : AgencyService {
        return when (deliveryAgencyType) {
            DeliveryAgencyType.SAMPLE_COMPANY -> sampleCompanyService
            DeliveryAgencyType.SELF_DELIVERY -> selfDeliveryService
        }
    }
}