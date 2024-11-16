package ru.shadrinsa.bookimori_api.api.factories;

import org.springframework.stereotype.Component;
import ru.shadrinsa.bookimori_api.api.dto.book.BookDto;
import ru.shadrinsa.bookimori_api.storage.enities.book.BookEntity;

@Component
public class BookDtoFactory {
    public BookDto makeBookDto(BookEntity entity){
        return BookDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .genre(entity.getGenre())
                .rating(entity.getRating())
                .createdAt(entity.getCreatedAt())
                .cover(entity.getCover())
                .build();
    }
}
