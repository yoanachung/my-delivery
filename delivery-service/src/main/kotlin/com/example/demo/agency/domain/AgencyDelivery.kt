package com.example.demo.agency.domain

import com.example.demo.agency.domain.status.AcceptedStatus
import com.example.demo.agency.domain.status.CanceledStatus
import com.example.demo.agency.domain.status.CompletedStatus
import com.example.demo.agency.domain.status.DepartedStatus

class AgencyDelivery(
    val deliveryId: Long,
    val type: DeliveryAgencyType,
) {
    var id: Long? = null
        protected set

    var status: AgencyDeliveryStatus = AcceptedStatus()
        protected set

    fun depart() {
        status.verifyCanDepart()
        this.status = DepartedStatus()
    }

    fun complete() {
        status.verifyCanComplete()
        this.status = CompletedStatus()
    }

    fun cancel() {
        status.verifyCanCancel()
        this.status = CanceledStatus()
    }
}