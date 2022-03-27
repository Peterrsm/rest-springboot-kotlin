package com.hc.mercadolivro.controller

import com.hc.mercadolivro.extension.toCustomerModel
import com.hc.mercadolivro.model.CustomerModel
import com.hc.mercadolivro.request.PostCustomerRequest
import com.hc.mercadolivro.request.PutCustomerRequest
import com.hc.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(
    val service : CustomerService
) {

    @GetMapping("/")
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return service.getAll(name)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel{
        return service.getCustomer(id)
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest){
        service.create(customer.toCustomerModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody customer: PutCustomerRequest){
        service.update(customer.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String){
        service.delete(id)
    }

}