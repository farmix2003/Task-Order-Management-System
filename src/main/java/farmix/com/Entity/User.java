package farmix.com.Entity;

import farmix.com.Entity.Role;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a user in the system.
 * Users belong to an organization and have specific roles that determine their permissions and access levels.
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    /** Unique identifier for the user */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Organization to which this user belongs */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
    private farmix.com.Entity.Organization organization;

    /** User's first name */
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    /** User's last name */
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    /** User's email address (must be unique for authentication) */
    @Column(nullable = false, unique = true)
    private String email;

    /** User's encrypted password */
    @Column(nullable = false)
    private String password;

    /** User's role within the organization (ADMIN, MANAGER, EMPLOYEE) */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Role role;

    /** Flag indicating whether the user account is active */
    @Column(nullable = false)
    private Boolean active;

    /** Timestamp when the user account was created (immutable) */
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    /** Timestamp when the user account was last updated */
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
}