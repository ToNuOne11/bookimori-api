package ru.shadrinsa.bookimori_api.storage.enities.book;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Genre")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
