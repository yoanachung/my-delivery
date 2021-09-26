package com.example.demo.agency.domain.status

import com.example.demo.agency.domain.AgencyDeliveryStatus

class AcceptedStatus : AgencyDeliveryStatus {
    override fun verifyCanDepart() {
    }

    override fun verifyCanCancel() {
    }

    override fun verifyCanComplete() {
    }
}