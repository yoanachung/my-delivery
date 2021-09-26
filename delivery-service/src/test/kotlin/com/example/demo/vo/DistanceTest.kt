package com.example.demo.vo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class DistanceTest {
    @ParameterizedTest
    @CsvSource(value = ["0.23, 0.2", "0.29, 0.2"])
    fun `roundedDown - 소수점 2번째 자리에서 버림된 값을 생성한다`(number: Double, expected: Double) {
        val distance = Distance.roundedDown(number)

        assertThat(distance).isEqualTo(Distance(expected))
    }
}