package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel{
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    Review review;

    @Enumerated(value = EnumType.STRING)
    BookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    private Long totalDistance;
    @ManyToOne
    private Driver driver;
    
    @ManyToOne
    private Passenger passenger;


}
