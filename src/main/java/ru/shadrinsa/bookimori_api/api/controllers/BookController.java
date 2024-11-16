package ru.shadrinsa.bookimori_api.api.controllers;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shadrinsa.bookimori_api.api.dto.book.BookDto;
import ru.shadrinsa.bookimori_api.api.services.BookService;

import java.util.List;

@RestController
@AllArgsConstructor
@Transactional
public class BookController {
    private final BookService bookService;
    @GetMapping("/api/books")
    public List<BookDto> getAllBooks(){
        return bookService.getAll();
    }
}
