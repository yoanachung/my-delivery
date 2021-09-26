package com.example.demo.vo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CoordinatesTest {
    @Test
    fun `distanceTo - 주어진 좌표와의 거리(km)를 조회한다`() {
        val from = Coordinates(37.49378114687084, 127.01370532552988)
        val to = Coordinates(37.504728092577984, 127.04881255699448)

        val distance = from.distanceTo(to)

        assertThat(distance).isEqualTo(Distance(3.3))
    }
}