package com.example.demo.store.domain

import com.example.demo.vo.DeliveryFee
import com.example.demo.vo.Distance
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class StoreDeliveryFeeTest {
    @ParameterizedTest
    @CsvSource(value = ["0.9999, false", "1.0, true", "2.0, true", "2.0001, false"])
    fun `fitDistance - 주어진 거리에 해당하는 배달비인지 조회한다`(distance: Double, expected: Boolean) {
        val storeDeliveryFee = StoreDeliveryFee(DeliveryFee(1_000), Distance(1.0), Distance(2.0))

        val fitDistance = storeDeliveryFee.fittedDistance(Distance(distance))

        assertThat(fitDistance).isEqualTo(expected)
    }
}