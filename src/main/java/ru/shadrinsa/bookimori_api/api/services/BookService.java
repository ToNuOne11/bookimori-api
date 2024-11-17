package ru.shadrinsa.bookimori_api.api.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shadrinsa.bookimori_api.api.dto.book.BookDto;
import ru.shadrinsa.bookimori_api.api.exeptions.NotFoundException;
import ru.shadrinsa.bookimori_api.api.factories.BookDtoFactory;
import ru.shadrinsa.bookimori_api.storage.enities.book.BookEntity;
import ru.shadrinsa.bookimori_api.storage.repositories.book.BookRepository;

import java.util.List;
import java.util.Optional;

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

    public BookDto getBook(Long bookId) {
        BookEntity book = getBookOrThrowException(bookId);
        return bookDtoFactory.makeBookDto(book);
    }

    private BookEntity getBookOrThrowException(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(
                () -> new NotFoundException("Book not found")
        );
    }
}
