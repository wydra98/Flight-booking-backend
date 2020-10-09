package flight_booking.backend.repository;

import flight_booking.backend.models.Airport;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class TestAirportRepository implements AirportRepository {

    @Override
    public int amountOfRows() {
        return 0;
    }

    @Override
    public int checkIfAirportExistsThroughName(String name, String city) {
        return 0;
    }

    @Override
    public int checkIfAirportExistsThroughCoordinates(double longitude, double latitude) {
        return 0;
    }

    @Override
    public List<Airport> findAll() {
        return null;
    }

    @Override
    public List<Airport> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Airport> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Airport> findAllById(Iterable<Long> iterable) {
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
    public void delete(Airport airport) {

    }

    @Override
    public void deleteAll(Iterable<? extends Airport> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Airport> S save(S s) {
        return null;
    }

    @Override
    public <S extends Airport> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Airport> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Airport> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Airport> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Airport getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Airport> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Airport> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Airport> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Airport> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Airport> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Airport> boolean exists(Example<S> example) {
        return false;
    }
}
