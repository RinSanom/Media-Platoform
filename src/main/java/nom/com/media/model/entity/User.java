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
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true, nullable = false)
        private String username;

        @Column(unique = true, nullable = false)
        private String email;

        @Column(nullable = false)
        private String passwordHash;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private Role role = Role.USER;

        @Column(nullable = false, updatable = false)
        private LocalDateTime createdAt = LocalDateTime.now();
    }

