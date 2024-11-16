package ru.shadrinsa.bookimori_api.api.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shadrinsa.bookimori_api.api.dto.book.BookDto;
import ru.shadrinsa.bookimori_api.api.factories.BookDtoFactory;
import ru.shadrinsa.bookimori_api.storage.repositories.book.BookRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookDtoFactory bookDtoFactory;

    public List<BookDto> getAll() {
        return bookRepository.streamAllBy()
                .map(bookDtoFactory::makeBookDto)
                .toList();
    }
}
