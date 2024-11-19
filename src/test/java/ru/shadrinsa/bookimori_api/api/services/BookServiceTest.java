package ru.shadrinsa.bookimori_api.api.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.shadrinsa.bookimori_api.api.dto.book.BookDto;
import ru.shadrinsa.bookimori_api.api.exeptions.BadRequestException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Test
    void testCheckValid_shouldThrowException_whenIncorrectParams() {

        BookDto bookWithBiggerParam = BookDto.builder()
                .rating((short) 11)
                .build();

        BookDto bookWithSmallerParam = BookDto.builder()
                .rating((short) 0)
                .build();


        Exception exceptionBigger = assertThrows(BadRequestException.class, () ->
                        bookService.checkValidParamsOrThrowException(bookWithBiggerParam)
                );

        Exception exceptionSmaller = assertThrows(BadRequestException.class, () ->
                bookService.checkValidParamsOrThrowException(bookWithSmallerParam)
        );

        Assertions.assertEquals("Rating must be from 1 to 10", exceptionBigger.getMessage());
        Assertions.assertEquals("Rating must be from 1 to 10", exceptionSmaller.getMessage());
    }
}