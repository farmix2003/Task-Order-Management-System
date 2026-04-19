package farmix.com.Entity;

/**
 * Enum representing different types of entities that can be audited.
 * Each type corresponds to a major entity in the application that requires audit tracking.
 */
public enum AuditEntityType {
    /** Organization entity type */
    ORGANIZATION,
    /** User entity type */
    USER,
    /** Project entity type */
    PROJECT,
    /** Task entity type */
    TASK,
    /** Comment entity type */
    COMMENT,
    /** Refresh token entity type */
    REFRESH_TOKEN
}
