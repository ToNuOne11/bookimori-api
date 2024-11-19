package ru.shadrinsa.bookimori_api.api.factories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.shadrinsa.bookimori_api.api.dto.book.BookDto;
import ru.shadrinsa.bookimori_api.api.services.GenreService;
import ru.shadrinsa.bookimori_api.storage.enities.book.BookEntity;

@Component
@RequiredArgsConstructor
public class BookDtoFactory {

    private final GenreService genreService;

    public BookDto makeBookDto(BookEntity entity) {
        return BookDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .description(entity.getDescription())
                .genre(entity.getGenre().getName())
                .rating(entity.getRating())
                .createdAt(entity.getCreatedAt())
                .cover(entity.getCover())
                .build();
    }

    public BookEntity makeBookEntity(BookDto dto) {
        return BookEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .description(dto.getDescription())
                .genre(genreService.findGenreByNameOrCreate(dto.getGenre()))
                .rating(dto.getRating())
                .createdAt(dto.getCreatedAt())
                .cover(dto.getCover())
                .build();
    }


}
