package ru.shadrinsa.bookimori_api.api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shadrinsa.bookimori_api.storage.enities.book.GenreEntity;
import ru.shadrinsa.bookimori_api.storage.repositories.book.GenreRepository;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreEntity findGenreByNameOrCreate(String name){

        GenreEntity genre = genreRepository.findByName(name);

        if(Objects.isNull(genre)){
            genre = GenreEntity.makeDefaultByName(name);
        }

        return genreRepository.saveAndFlush(genre);
    }

}
