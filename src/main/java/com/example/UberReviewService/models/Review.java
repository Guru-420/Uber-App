package com.example.UberReviewService.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Booking_Review")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{

    @Column(nullable = false)
    private String content;

    private Double rating;

    public String toString(){
        return "Review:"  + this.content + " " + this.rating;
    }
}
