package com.example.UberReviewService.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends BaseModel {
    private String name;

    @Column(nullable = false,unique = true)
    private String licenseNumber;

    @OneToMany(mappedBy = "driver")
    private List<Booking> dbookings = new ArrayList<>();
}
