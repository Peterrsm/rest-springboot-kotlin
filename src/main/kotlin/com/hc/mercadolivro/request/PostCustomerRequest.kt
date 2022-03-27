package com.hc.mercadolivro.request

import com.hc.mercadolivro.model.CustomerModel

data class PostCustomerRequest (
    var name: String,
    var email: String
    )