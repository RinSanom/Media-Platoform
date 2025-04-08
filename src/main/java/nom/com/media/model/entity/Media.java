package nom.com.media.model.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.io.Serializable;
    @Getter
    @Setter
    @NoArgsConstructor
    @Entity
    @Table(name = "media")
    public class Media {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
//
//        @ManyToOne
//        @JoinColumn(name = "user_id", nullable = false)
//        private User user;

        @Column(nullable = false)
        private String title;

        @Column
        private String description;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private MediaType mediaType;

        @Column(nullable = false)
        private String fileUrl;

        @Column(nullable = false, updatable = false)
        private LocalDateTime createdAt = LocalDateTime.now();
}
