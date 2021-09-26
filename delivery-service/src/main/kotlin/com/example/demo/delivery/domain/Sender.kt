package com.example.demo.delivery.domain

import com.example.demo.vo.Address

class Sender(
    val storeId: Long,
    val address: Address,
) {
    var id: Long? = null
        protected set
}