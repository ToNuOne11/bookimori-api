package ru.shadrinsa.bookimori_api.api.controllers;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shadrinsa.bookimori_api.api.dto.AckDto;
import ru.shadrinsa.bookimori_api.api.dto.book.BookDto;
import ru.shadrinsa.bookimori_api.api.services.BookService;
import ru.shadrinsa.bookimori_api.storage.enities.book.BookEntity;

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

    @GetMapping("/api/book/{book_id}")
    public BookDto getAllBooks(@PathVariable Long book_id){
        return bookService.getBook(book_id);
    }

    @DeleteMapping("/api/book/{book_id}")
    public AckDto deleteBook(@PathVariable Long book_id){
        return bookService.deleteBook(book_id);
    }
}
