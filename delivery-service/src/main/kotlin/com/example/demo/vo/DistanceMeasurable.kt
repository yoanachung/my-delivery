package com.example.demo.vo

@FunctionalInterface
interface DistanceMeasurable {
    fun distanceTo(toAddress: Address): Distance
}