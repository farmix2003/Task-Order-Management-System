package farmix.com.Entity;

/**
 * Enum representing different status states for a task.
 * Statuses track the progress of a task through its lifecycle.
 */
public enum TaskStatus {
    /** Task has been created but work has not started */
    TODO,
    /** Task is currently being worked on */
    IN_PROGRESS,
    /** Task is waiting for review or approval */
    IN_REVIEW,
    /** Task has been completed successfully */
    DONE,
    /** Task has been canceled and will not be completed */
    CANCELED
}
