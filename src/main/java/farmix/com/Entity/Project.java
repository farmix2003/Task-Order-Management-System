package farmix.com.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a project.
 * A project belongs to an organization and contains multiple tasks that can be assigned to users.
 */
@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {

    /** Unique identifier for the project */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Organization to which this project belongs */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    /** User who created the project */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    /** Name of the project */
    @Column(nullable = false)
    private String name;

    /** Description of the project's purpose and goals */
    @Column(columnDefinition = "TEXT")
    private String description;
}