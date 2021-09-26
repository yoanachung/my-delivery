package com.example.demo.agency.infra.samplecompany

import com.example.demo.agency.service.AgencyService
import com.example.demo.delivery.domain.Delivery
import org.springframework.stereotype.Service

@Service
class SampleCompanyService : AgencyService {
    override fun send(delivery: Delivery) {
        // ... 배달대행사에서 제공하는 API 호출
    }
}