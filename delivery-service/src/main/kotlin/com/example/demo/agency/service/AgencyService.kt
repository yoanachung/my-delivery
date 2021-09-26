package com.example.demo.agency.service

import com.example.demo.delivery.domain.Delivery

interface AgencyService {
    fun send(delivery: Delivery)
}