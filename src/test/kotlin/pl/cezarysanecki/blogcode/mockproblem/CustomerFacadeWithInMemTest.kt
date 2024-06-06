package pl.cezarysanecki.blogcode.mockproblem

import kotlin.test.Test
import kotlin.test.assertEquals

class CustomerFacadeWithInMemTest {

  private val customerRepository: CustomerRepository = InMemoryCustomerRepository()

  private val customerFacade: CustomerFacade = CustomerFacade(customerRepository)

  @Test
  fun updatingNames() {
    // given
    val newFirstName = "Mateusz"
    val newLastName = "Burczymuch"
    // and
    val customerId = customerFacade.addNewCustomer("Kazik", "Mazik")

    // when
    customerFacade.updateNames(customerId, newFirstName, newLastName)

    // then
    val result = customerRepository.findById(customerId).get()
    assertEquals(newFirstName, result.firstName)
    assertEquals(newLastName, result.lastName)
  }

}
