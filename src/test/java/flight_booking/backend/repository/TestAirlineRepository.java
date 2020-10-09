package flight_booking.backend.repository;

import flight_booking.backend.models.Airline;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;

public class TestAirlineRepository implements AirlineRepository {

    private Map<Integer, Airline> airlines = new HashMap<>();

    @Override
    public int amountOfRows() {
        return 0;
    }

    @Override
    public int checkIfAirlineExists(String name, String country) {
        return 0;
    }

    @Override
    public List<Airline> findAll() {
        return new ArrayList<>(airlines.values());
    }

    @Override
    public List<Airline> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Airline> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Airline> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Airline airline) {

    }

    @Override
    public void deleteAll(Iterable<? extends Airline> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Airline save(final Airline airline) {
        return airlines.put(airlines.size() + 1, airline);
    }

    @Override
    public <S extends Airline> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Airline> findById(Long id) {
        return Optional.ofNullable(airlines.get(id));
    }

    @Override
    public boolean existsById(Long id) {
        return airlines.containsKey(id);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Airline> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Airline> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Airline getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Airline> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Airline> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Airline> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Airline> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Airline> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Airline> boolean exists(Example<S> example) {
        return false;
    }
}
