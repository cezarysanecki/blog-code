package pl.cezarysanecki.blogcode.mockproblem;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

class InMemoryCustomerRepository implements CustomerRepository {

  private static final Map<Long, Customer> DATABASE = new ConcurrentHashMap<>();
  private static final AtomicLong ID_GENERATOR = new AtomicLong();

  @Override
  public <S extends Customer> S save(S entity) {
    if (entity.getId() == null) {
      entity.setId(ID_GENERATOR.incrementAndGet());
    }
    DATABASE.put(entity.getId(), entity);
    return entity;
  }

  @Override
  public Optional<Customer> findById(Long id) {
    return Optional.of(DATABASE.get(id));
  }

  @Override
  public <S extends Customer> Iterable<S> saveAll(Iterable<S> entities) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean existsById(Long aLong) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Iterable<Customer> findAll() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Iterable<Customer> findAllById(Iterable<Long> longs) {
    throw new UnsupportedOperationException();
  }

  @Override
  public long count() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void deleteById(Long aLong) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void delete(Customer entity) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void deleteAllById(Iterable<? extends Long> longs) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void deleteAll(Iterable<? extends Customer> entities) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void deleteAll() {
    throw new UnsupportedOperationException();
  }

}
