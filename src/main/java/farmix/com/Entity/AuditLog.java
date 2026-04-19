package farmix.com.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
 * Entity representing an audit log record.
 * Tracks all changes made to entities within an organization for compliance and debugging purposes.
 * Each audit log entry contains information about what was changed, by whom, and when.
 */
@Getter
@Setter
@Entity
@Table(name = "audit_logs")
public class AuditLog {

    /** Unique identifier for the audit log entry */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Organization to which this audit log belongs */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    /** Type of entity that was audited (e.g., TASK, USER, PROJECT) */
    @Enumerated(EnumType.STRING)
    @Column(name = "entity_type", nullable = false, length = 50)
    private AuditEntityType entityType;

    /** ID of the entity that was audited */
    @Column(name = "entity_id", nullable = false)
    private Long entityId;

    /** Action performed on the entity (e.g., CREATE, UPDATE, DELETE) */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private AuditAction action;

    /** Previous value before the change (for UPDATE actions) */
    @Column(name = "old_value", columnDefinition = "TEXT")
    private String oldValue;

    /** New value after the change (for UPDATE actions) */
    @Column(name = "new_value", columnDefinition = "TEXT")
    private String newValue;

    /** User who performed the action */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "performed_by", nullable = false)
    private User performedBy;

    /** Timestamp when the action was performed */
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}