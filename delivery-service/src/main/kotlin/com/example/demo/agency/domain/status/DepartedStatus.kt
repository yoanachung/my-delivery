package com.example.demo.agency.domain.status

import com.example.demo.agency.domain.AgencyDeliveryStatus
import com.example.demo.exception.DeliveryException

class DepartedStatus : AgencyDeliveryStatus {
    override fun verifyCanDepart() {
        throw DeliveryException("이미 출발한 배달이므로 중복 출발할 수 없습니다.")
    }

    override fun verifyCanCancel() {
    }

    override fun verifyCanComplete() {
    }
}