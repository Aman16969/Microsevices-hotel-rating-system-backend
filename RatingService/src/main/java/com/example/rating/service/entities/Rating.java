package com.example.rating.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("user_ratings")
public class Rating {
    @Id
    private String ratingId;
    private String hotelId;
    private String userId;
    private String feedback;
    private int rating;
}
