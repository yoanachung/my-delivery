package com.example.demo.delivery.domain

enum class DeliveryStatus(private val description: String) {
    READY ("배달 시작 전"),
    DEPARTED ("배달 출발됨"),
    COMPLETED ("배달 완료됨"),
    CANCELED ("배달 취소됨"),
    ;
}