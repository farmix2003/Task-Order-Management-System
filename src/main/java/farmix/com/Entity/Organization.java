package farmix.com.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing an organization.
 * An organization is the top-level entity that contains users, projects, and tasks.
 */
@Getter
@Setter
@Entity
@Table(name = "organizations")
public class Organization {
    /** Unique identifier for the organization */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Name of the organization (must be unique) */
    @Column(nullable = false, unique = true)
    private String name;

    /** Timestamp when the organization was created (immutable) */
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    /** Timestamp when the organization was last updated */
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
}