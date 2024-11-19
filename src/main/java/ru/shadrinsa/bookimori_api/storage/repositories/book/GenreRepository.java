package ru.shadrinsa.bookimori_api.storage.repositories.book;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shadrinsa.bookimori_api.storage.enities.book.GenreEntity;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
    GenreEntity findByName(String name);
}
