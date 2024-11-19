package ru.shadrinsa.bookimori_api.api.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ru.shadrinsa.bookimori_api.storage.enities.book.ImageEntity;

import java.time.Instant;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String description;
    private String genre;
    @Column(name = "rating")
    private Short rating;
    @JsonProperty("created_at")
    private Instant createdAt = Instant.now();
    private ImageEntity cover;

}
