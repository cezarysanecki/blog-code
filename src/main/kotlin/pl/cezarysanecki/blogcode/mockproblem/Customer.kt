package pl.cezarysanecki.blogcode.mockproblem

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.AccessLevel
import lombok.NoArgsConstructor

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
internal class Customer(
  var firstName: String,
  var lastName: String
) {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  var id: Long? = null

  constructor(id: Long, firstName: String, lastName: String) : this(firstName, lastName) {
    this.id = id
  }

}
