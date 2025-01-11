package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.DriverRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.*;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;
    public ReviewService(ReviewRepository reviewRepository,BookingRepository bookingRepository,DriverRepository driverRepository){
        this.bookingRepository=bookingRepository;
        this.reviewRepository=reviewRepository;
        this.driverRepository=driverRepository;
    }
    @Override
    @Transactional
    public void run(String... args) throws Exception {

//        Review r = Review
//                    .builder()
//                    .content("Amazing ride quality")
//                    .rating(5.0).
//                    build();
//
//        Booking b = Booking.builder().review(r).endTime(new Date()).build();
//
//        bookingRepository.save(b);
//
//        List<Review> reviews = reviewRepository.findAll();
//        for(Review review: reviews)
//            System.out.println(reviewRepository.save(review));
//        Optional<Booking> b = bookingRepository.findById(1L);
//        if(b.isPresent())
//            bookingRepository.delete(b.get());

//        Optional<Driver> driver = driverRepository.findByIdAndLicenseNumber(1L,"FGF11222");
//        if(driver.isPresent()){
//            System.out.println(driver.get().getName());
//            List<Booking> bookings = bookingRepository.findALlByDriverId(1L);
//            for(Booking booking:bookings){
//                System.out.println(booking.getBookingStatus());
//            }
//        }
//        Optional<Driver> driver = driverRepository.hqlFindByIdAndLicenseNumber(1L,"FGF11222");
//        if(driver.isPresent()) {
//           System.out.println(driver.get().getName());
//        }


        List<Long> driverIds = new ArrayList<>(Arrays.asList(1L,2L,3L,4L,5L));
        List<Driver> drivers = driverRepository.findAllByIdIn(driverIds);

        for(Driver driver : drivers){
            List<Booking> bookings = driver.getBookings();
            bookings.forEach(booking -> System.out.println(booking.getId()));
        }
    }
}
