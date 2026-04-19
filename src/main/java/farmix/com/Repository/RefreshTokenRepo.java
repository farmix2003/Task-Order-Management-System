package farmix.com.Repository;

import farmix.com.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Repository interface for managing RefreshToken entities.
 *
 * This repository handles CRUD operations and custom queries for refresh tokens used
 * in the JWT-based authentication system. Refresh tokens allow users to obtain new
 * access tokens without re-authenticating. It provides methods for token validation,
 * revocation, and cleanup of expired tokens.
 */
@Repository
public interface RefreshTokenRepo extends JpaRepository<farmix.com.Entity.RefreshToken, Long> {

    /**
     * Retrieves an active (non-revoked) refresh token by its token value.
     *
     * @param token the refresh token string
     * @return an Optional containing the refresh token if found and not revoked, empty otherwise
     */
    Optional<RefreshTokenRepo> findByTokenAndRevokedFalse(String token);

    /**
     * Deletes all refresh tokens associated with a specific user.
     * Used when a user logs out or changes their password to invalidate all sessions.
     *
     * @param user the user whose tokens should be deleted
     */
    void deleteAllByUser(User user);

    /**
     * Deletes all expired refresh tokens before a given date/time.
     * Used for periodic cleanup to remove stale tokens from the database.
     *
     * @param expiresAtBefore the cutoff timestamp; tokens expiring before this time will be deleted
     * @return the number of tokens deleted
     */
    long deleteByExpiresAtBefore(LocalDateTime expiresAtBefore);
}
