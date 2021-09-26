package com.example.demo

import com.example.demo.vo.Address
import com.example.demo.vo.Coordinates

class TestObjects {
    companion object {
        val 좌표 = Coordinates(
            latitude = 0.0,
            longitude = 0.0,
        )

        val 주소 = Address(
            roadAddress = "",
            detailAddress = "",
            zipcode = "",
            coordinates = 좌표,
        )
    }
}