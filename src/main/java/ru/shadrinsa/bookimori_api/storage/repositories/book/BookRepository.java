package ru.shadrinsa.bookimori_api.storage.repositories.book;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shadrinsa.bookimori_api.storage.enities.book.BookEntity;

import java.util.stream.Stream;

public interface BookRepository extends JpaRepository <BookEntity, Long> {
    Stream<BookEntity> streamAllBy();
}
