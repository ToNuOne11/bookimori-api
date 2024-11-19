package ru.shadrinsa.bookimori_api.api.controllers;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shadrinsa.bookimori_api.api.dto.AckDto;
import ru.shadrinsa.bookimori_api.api.dto.book.BookDto;
import ru.shadrinsa.bookimori_api.api.services.BookService;

import java.util.List;

@RestController
@AllArgsConstructor
@Transactional
public class BookController {

    private final BookService bookService;

    @GetMapping("/api/book")
    public List<BookDto> getAllBooks(){
        return bookService.getAllBook();
    }

    @GetMapping("/api/book/{book_id}")
    public BookDto getAllBooks(@PathVariable Long book_id){
        return bookService.getBook(book_id);
    }

    @PostMapping("/api/book")
    public BookDto addBook(@RequestBody BookDto book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/api/book/{book_id}")
    public AckDto deleteBook(@PathVariable Long book_id){
        return bookService.deleteBook(book_id);
    }
}
