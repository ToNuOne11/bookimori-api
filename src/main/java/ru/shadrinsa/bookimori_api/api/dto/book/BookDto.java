package ru.shadrinsa.bookimori_api.api.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
    private Short rating;
    @JsonProperty("created_at")
    private Instant createdAt = Instant.now();
    private String cover;

}
