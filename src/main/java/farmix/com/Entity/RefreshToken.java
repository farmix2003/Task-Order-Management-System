package farmix.com.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a refresh token for user authentication.
 * Refresh tokens are used to obtain new access tokens without requiring the user to log in again.
 */
@Getter
@Setter
@Entity
@Table(name = "refresh_tokens")
public class RefreshToken {

    /** Unique identifier for the refresh token */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** User to whom this refresh token is associated */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /** The refresh token value (must be unique) */
    @Column(nullable = false, unique = true, length = 500)
    private String token;

    /** Timestamp when the refresh token expires */
    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    /** Flag indicating whether the token has been revoked */
    @Column(nullable = false)
    private Boolean revoked = false;

    /** Timestamp when the refresh token was created */
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}