package com.example.demo.store.repo

import com.example.demo.store.domain.Store
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository {
    fun save(store: Store)
    fun findByStoreId(storeId: Long): Store
}