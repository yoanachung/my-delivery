package com.example.demo.agency.repo

import com.example.demo.agency.domain.AgencyDelivery
import org.springframework.stereotype.Repository

@Repository
interface AgencyDeliveryRepository {
    fun save(agencyDelivery: AgencyDelivery)
    fun findById(id: Long): AgencyDelivery
}