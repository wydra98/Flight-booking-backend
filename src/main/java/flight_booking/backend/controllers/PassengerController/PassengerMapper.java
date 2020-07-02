package flight_booking.backend.controllers.PassengerController;

import flight_booking.backend.models.Passenger.Passenger;

import java.time.LocalDate;

public class PassengerMapper {

    public PassengerDto map(Passenger passenger) {
        return PassengerDto.builder()
                .id(passenger.getId())
                .firstName(passenger.getFirstName())
                .surname(passenger.getSurname())
                .dateOfBirth(passenger.getDateOfBirth().toString())
                .phoneNumber(passenger.getPhoneNumber())
                .email(passenger.getEmail())
                .build();
    }
}