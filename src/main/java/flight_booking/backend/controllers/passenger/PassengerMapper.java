package flight_booking.backend.controllers.passenger;

import flight_booking.backend.models.Passenger;

public class PassengerMapper {

    public PassengerDto map(Passenger passenger) {
        return PassengerDto.builder()
                .id(passenger.getId())
                .pesel(passenger.getPesel())
                .firstName(passenger.getFirstName())
                .surname(passenger.getSurname())
                .documentId(passenger.getDocumentId())
                .phoneNumber(passenger.getPhoneNumber())
                .email(passenger.getEmail())
                .build();
    }
}
