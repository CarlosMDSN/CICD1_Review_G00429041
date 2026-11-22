package ie.atu.sample.controller;

import ie.atu.sample.dto.BookingRequestDTO;
import ie.atu.sample.dto.BookingResponseDTO;
import ie.atu.sample.service.BookingService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponseDTO createBooking(
            @Valid @RequestBody BookingRequestDTO request) {

        return bookingService.createBooking(request);
    }
    @GetMapping("/{id}")
    public BookingResponseDTO getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }
}