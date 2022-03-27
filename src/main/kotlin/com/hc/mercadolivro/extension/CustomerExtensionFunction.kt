package com.hc.mercadolivro.extension

import com.hc.mercadolivro.model.CustomerModel
import com.hc.mercadolivro.request.PostCustomerRequest
import com.hc.mercadolivro.request.PutCustomerRequest

fun PostCustomerRequest.toCustomerModel() : CustomerModel{
    return CustomerModel(name = this.name, email = this.email)
}
fun PutCustomerRequest.toCustomerModel(id: String) : CustomerModel{
    return CustomerModel(id = id, name = this.name, email = this.email)
}

