package com.example.demo.agency.domain.status

import com.example.demo.agency.domain.AgencyDeliveryStatus
import com.example.demo.exception.DeliveryException

class CanceledStatus : AgencyDeliveryStatus {
    override fun verifyCanDepart() {
        throw DeliveryException("이미 취소된 배달이므로 출발할 수 없습니다.")
    }

    override fun verifyCanCancel() {
        throw DeliveryException("이미 취소된 배달이므로 중복 취소할 수 없습니다.")
    }

    override fun verifyCanComplete() {
        throw DeliveryException("이미 취소된 배달이므로 완료할 수 없습니다.")
    }
}