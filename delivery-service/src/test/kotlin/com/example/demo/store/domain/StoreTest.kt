package com.example.demo.store.domain

import com.example.demo.TestObjects
import com.example.demo.agency.domain.DeliveryAgencyType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StoreTest {

    @Test
    fun addDeliveryAgency() {
        val store = Store(
            storeId = 1,
            name = "test store",
            address = TestObjects.주소,
        )

        store.addDeliveryAgency(StoreDeliveryAgency(
            storeId = 1,
            deliveryAgencyType = DeliveryAgencyType.SELF_DELIVERY,
        ))

        store.addDeliveryAgency(StoreDeliveryAgency(
            storeId = 1,
            deliveryAgencyType = DeliveryAgencyType.SAMPLE_COMPANY,
        ))

        assertThat(store.storeDeliveryAgencies.size()).isEqualTo(2)
        assertThat(store.storeDeliveryAgencies[0].deliveryAgencyType).isEqualTo(DeliveryAgencyType.SELF_DELIVERY)
        assertThat(store.storeDeliveryAgencies[1].deliveryAgencyType).isEqualTo(DeliveryAgencyType.SAMPLE_COMPANY)
    }
}