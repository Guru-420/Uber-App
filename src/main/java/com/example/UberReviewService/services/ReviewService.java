package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.DriverRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        Optional<Driver> driver = driverRepository.hqlFindByIdAndLicenseNumber(1L,"FGF11222");
        if(driver.isPresent()) {
           System.out.println(driver.get().getName());
        }

    }
}
