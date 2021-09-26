package com.example.demo.exception

data class DeliveryException(
    override val message: String? = null,
    override val cause: Throwable? = null,
): RuntimeException(cause)