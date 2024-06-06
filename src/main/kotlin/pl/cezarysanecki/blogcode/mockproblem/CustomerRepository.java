package pl.cezarysanecki.blogcode.mockproblem;

import org.springframework.data.repository.CrudRepository;

interface CustomerRepository extends CrudRepository<Customer, Long> {

  default Customer getById(Long customerId) {
    return findById(customerId)
        .orElseThrow(() -> new IllegalArgumentException("Customer with id $id not found"));
  }

}
