package com.example.demo.agency.domain

interface AgencyDeliveryStatus {
    fun verifyCanDepart()
    fun verifyCanCancel()
    fun verifyCanComplete()
}