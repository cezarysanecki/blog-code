package pl.cezarysanecki.blogcode.mockproblem

import org.mockito.Mockito
import java.util.*
import kotlin.test.Test

class CustomerFacadeWithMockTest {

  private val customerRepository: CustomerRepository = Mockito.mock(CustomerRepository::class.java)

  private val customerFacade: CustomerFacade = CustomerFacade(customerRepository)

  @Test
  fun updatingNames() {
    // given
    val id = 12L
    val firstName = "Kazik"
    val lastName = "Mazik"
    // and
    val customer = Customer(id, firstName, lastName)
    Mockito.`when`(customerRepository.save(Mockito.any())).thenReturn(customer)
    Mockito.`when`(customerRepository.findById(id)).thenReturn(Optional.of(customer))
    // and
    val customerId = customerFacade.addNewCustomer(firstName, lastName)

    // when
    customerFacade.updateNames(customerId, "Mateusz", "Burczymuch")

    // then
    // ???
  }

}
