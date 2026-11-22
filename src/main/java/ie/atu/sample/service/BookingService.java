package ie.atu.sample.service;

import ie.atu.sample.client.RoomClient;
import ie.atu.sample.dto.BookingRequestDTO;
import ie.atu.sample.dto.BookingResponseDTO;
import ie.atu.sample.dto.RoomResponseDTO;
import ie.atu.sample.model.BookingModel;
import ie.atu.sample.repository.BookingRepository;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomClient roomClient;

    public BookingService(BookingRepository bookingRepository, RoomClient roomClient) {
        this.bookingRepository = bookingRepository;
        this.roomClient = roomClient;
    }

    public BookingResponseDTO createBooking(BookingRequestDTO request) {

        // Retrieve room information from Room Service
        RoomResponseDTO room = roomClient.getRoomById(request.getRoomId());

        // Check attendee count against room capacity
        if (request.getAttendeeCount() > room.getCapacity()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Attendee count exceeds room capacity"
            );
        }

        // Create and save booking
        BookingModel booking = new BookingModel();
        booking.setOrganiserName(request.getOrganiserName());
        booking.setAttendeeCount(request.getAttendeeCount());
        booking.setRoomId(request.getRoomId());
        booking.setStatus("ACTIVE");

        BookingModel savedBooking = bookingRepository.save(booking);

        // Return response DTO
        return new BookingResponseDTO(
                savedBooking.getId(),
                savedBooking.getOrganiserName(),
                savedBooking.getAttendeeCount(),
                savedBooking.getRoomId(),
                savedBooking.getStatus()
        );
    }
    public BookingResponseDTO getBookingById(Long id) {

        BookingModel booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Booking not found with ID: " + id
                ));

        return new BookingResponseDTO(
                booking.getId(),
                booking.getOrganiserName(),
                booking.getAttendeeCount(),
                booking.getRoomId(),
                booking.getStatus()
        );
    }
}