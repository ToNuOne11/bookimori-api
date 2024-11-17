package ru.shadrinsa.bookimori_api.storage.enities.book;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "book")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;
    @Column(name = "rating")
    private Short rating;
    @Builder.Default
    private Instant createdAt = Instant.now();
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cover_id")
    private ImageEntity cover;
    public void addImageToBook(ImageEntity image) {
        image.setBookEntity(this);
        cover = image;
    }
}