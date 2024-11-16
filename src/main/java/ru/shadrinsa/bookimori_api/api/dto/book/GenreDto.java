package ru.shadrinsa.bookimori_api.api.dto.book;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto {
    private Long id;
    @NonNull
    private String name;
}
