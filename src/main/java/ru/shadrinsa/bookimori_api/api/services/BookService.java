package ru.shadrinsa.bookimori_api.api.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shadrinsa.bookimori_api.api.dto.AckDto;
import ru.shadrinsa.bookimori_api.api.dto.book.BookDto;
import ru.shadrinsa.bookimori_api.api.exeptions.BadRequestException;
import ru.shadrinsa.bookimori_api.api.exeptions.NotFoundException;
import ru.shadrinsa.bookimori_api.api.factories.BookDtoFactory;
import ru.shadrinsa.bookimori_api.storage.enities.book.BookEntity;
import ru.shadrinsa.bookimori_api.storage.repositories.book.BookRepository;

import java.util.List;
import java.util.Objects;

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

    public BookDto addBook(BookDto book) {

        checkValidParamsOrThrowException(book);

        BookEntity savedBook = bookRepository
                .saveAndFlush(bookDtoFactory.makeBookEntity(book));

        return bookDtoFactory.makeBookDto(savedBook);

    }

    public AckDto deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
        return AckDto.makeDefault(true);
    }

    public void checkValidParamsOrThrowException(BookDto book) {

        if (Objects.nonNull(book.getRating()) && (book.getRating() > 10 || book.getRating() < 1)) {
            throw new BadRequestException("Rating must be from 1 to 10");
        }

    }
}
