package farmix.com.Entity;

/**
 * Enum representing different priority levels for tasks.
 * Priority levels help users understand the importance and urgency of a task.
 */
public enum TaskPriority {
    /** Low priority task that can be addressed later */
    LOW,
    /** Medium priority task that should be addressed in normal workflow */
    MEDIUM,
    /** High priority task that requires prompt attention */
    HIGH,
    /** Critical priority task that requires immediate attention */
    CRITICAL
}
