package pl.cezarysanecki.blogcode.mockproblem

import jakarta.transaction.Transactional

open class CustomerFacade internal constructor(
  private val customerRepository: CustomerRepository
) {

  @Transactional
  open fun addNewCustomer(firstName: String, lastName: String): Long {
    val customer = customerRepository.save(Customer(firstName, lastName))
    return customer.id ?: throw RuntimeException("Customer was not created")
  }

  @Transactional
  open fun updateNames(customerId: Long, firstName: String, lastName: String) {
    val customer = customerRepository.getById(customerId)

    customer.firstName = firstName
    customer.lastName = lastName
  }

}
