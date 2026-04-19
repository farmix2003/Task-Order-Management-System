package farmix.com.Entity;

/**
 * Enum representing different types of audit actions that can be performed on entities.
 * These actions are tracked in the audit log for compliance and debugging purposes.
 */
public enum AuditAction {
    /** Action for creating a new entity */
    CREATE,
    /** Action for updating an existing entity */
    UPDATE,
    /** Action for deleting an entity */
    DELETE,
    /** Action for assigning a task to a user */
    ASSIGN,
    /** Action for changing the status of an entity */
    STATUS_CHANGE,
    /** Action for user login */
    LOGIN
}
