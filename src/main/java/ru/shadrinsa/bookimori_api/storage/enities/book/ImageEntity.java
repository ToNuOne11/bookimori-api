package ru.shadrinsa.bookimori_api.storage.enities.book;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "image")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String originalFileName;

    private String contentType;

    private Long size;
    @Lob
    private byte[] bytes;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BookEntity bookEntity;
}