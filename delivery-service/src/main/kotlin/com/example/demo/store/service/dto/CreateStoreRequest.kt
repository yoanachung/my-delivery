package com.example.demo.store.service.dto

import com.example.demo.vo.Address

class CreateStoreRequest(
    val storeId: Long,
    val name: String,
    val address: Address,
)
