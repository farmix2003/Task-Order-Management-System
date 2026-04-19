package farmix.com.Entity;

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
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a task within a project.
 * Tasks are work items that can be assigned to users and tracked through various status and priority levels.
 */
@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {

    /** Unique identifier for the task */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Organization to which this task belongs */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    /** Project to which this task belongs */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    /** User assigned to complete the task (can be null if unassigned) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    private User assignee;

    /** User who created/reported the task */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reporter_id", nullable = false)
    private User reporter;

    /** Title or name of the task */
    @Column(nullable = false)
    private String title;

    /** Detailed description of the task */
    @Column(columnDefinition = "TEXT")
    private String description;

    /** Current status of the task (e.g., TODO, IN_PROGRESS, DONE) */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TaskStatus status;

    /** Priority level of the task (e.g., LOW, MEDIUM, HIGH, CRITICAL) */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TaskPriority priority;

    /** Due date for completing the task */
    @Column(name = "due_date")
    private LocalDateTime dueDate;
}