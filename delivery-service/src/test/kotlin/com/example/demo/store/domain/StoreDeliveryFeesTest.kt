package com.example.demo.store.domain

import com.example.demo.vo.DeliveryFee
import com.example.demo.vo.Distance
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class StoreDeliveryFeesTest {
    private val storeDeliveryFees = StoreDeliveryFees(
        listOf(
            StoreDeliveryFee(DeliveryFee(1_000), Distance(0.0), Distance(0.5)),
            StoreDeliveryFee(DeliveryFee(2_000), Distance(0.5), Distance(1.0)),
            StoreDeliveryFee(DeliveryFee(3_000), Distance(1.0), Distance(2.0)),
        )
    )

    @ParameterizedTest
    @CsvSource(value = ["0.0, 1000", "0.5, 1000", "0.7, 2000", "1.0, 2000", "1.0001, 3000"])
    fun `deliveryFee - 주어진 거리에 따른 배송비를 조회한다`(distance: Double, expected: Int) {
        val deliveryFee = storeDeliveryFees.deliveryFee(Distance(distance))

        assertThat(deliveryFee).isEqualTo(DeliveryFee(expected))
    }
}