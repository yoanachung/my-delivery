package com.example.demo.vo

data class Address(
    val roadAddress: String,
    val detailAddress: String,
    val zipcode: String,
    val coordinates: Coordinates,
) : DistanceMeasurable {
    override fun distanceTo(toAddress: Address): Distance {
        return coordinates.distanceTo(toAddress.coordinates)
    }
}