package com.example.demo.store.service

import com.example.demo.store.domain.Store
import com.example.demo.store.domain.StoreDeliveryAgency
import com.example.demo.store.domain.StoreDeliveryFee
import com.example.demo.store.domain.StoreDeliveryFees
import com.example.demo.store.repo.StoreRepository
import com.example.demo.store.service.dto.*
import com.example.demo.vo.DeliveryFee
import com.example.demo.vo.Distance
import org.springframework.stereotype.Service

@Service
class StoreService(
    private val storeRepository: StoreRepository,
) {
    fun create(request: CreateStoreRequest) {
        val store = Store(
            storeId = request.storeId,
            name = request.name,
            address = request.address
        )

        storeRepository.save(store)
    }

    fun update(request: UpdateStoreRequest) {
        val store = storeRepository.findByStoreId(request.storeId)

        if (request.name != null) {
            store.updateName(request.name)
        }
    }

    fun addDeliveryAgency(request: AddStoreDeliveryAgencyRequest) {
        val store = storeRepository.findByStoreId(request.storeId)

        val storeDeliveryAgency = StoreDeliveryAgency(
            storeId = store.storeId,
            deliveryAgencyType = request.deliveryAgencyType,
        )

        store.addDeliveryAgency(storeDeliveryAgency)
    }

    fun updateDeliveryFees(request: UpdateDeliveryFeesRequest) {
        val store = storeRepository.findByStoreId(request.storeId)

        val deliveryFees = request.deliveryFees.map {
            StoreDeliveryFee(
                deliveryFee = DeliveryFee(it.deliveryFee),
                minDistance = Distance(it.minDistance),
                maxDistance = Distance(it.maxDistance),
            )
        }.let { StoreDeliveryFees(it) }

        store.updateDeliveryFees(request.deliveryAgencyType, deliveryFees)
    }
}