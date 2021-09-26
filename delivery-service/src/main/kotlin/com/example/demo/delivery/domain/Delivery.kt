package com.example.demo.delivery.domain

class Delivery(
    val orderId: String,
    val deliveryProduct: DeliveryProduct,
    val sender: Sender,
    val receiver: Receiver,
){
    var id: Long? = null
        protected set

    var status: DeliveryStatus = DeliveryStatus.READY
        protected set

    fun changeStatus(status: DeliveryStatus) {
        this.status = status
    }
}