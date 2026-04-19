package farmix.com.Repository;

import farmix.com.Entity.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing Task entities.
 *
 * This repository provides CRUD operations and custom query methods for tasks.
 * Tasks represent individual work items within projects and are scoped to organizations.
 * It includes methods for filtering by assignee, project, and status, with support
 * for pagination and entity graph optimization to prevent N+1 query problems.
 */
@Repository
public interface TaskRepo extends JpaRepository<farmix.com.Entity.Task, Long> {

    /**
     * Retrieves a task by its ID within a specific organization.
     *
     * @param id the task ID
     * @param organizationId the ID of the organization (for multi-tenancy/security)
     * @return an Optional containing the task if found, empty otherwise
     */
    Optional<TaskRepo> findAllByIdAndOrganization_Id(Long id, Long organizationId);

    /**
     * Checks if a task with the given ID exists within an organization.
     *
     * @param id the task ID
     * @param organizationId the ID of the organization
     * @return true if the task exists in the organization, false otherwise
     */
    boolean existsByIdAndOrganization_Id(Long id, Long organizationId);

    /**
     * Retrieves a task by its ID within an organization with eager loading of related entities.
     *
     * Uses @EntityGraph to load the project, assignee, and reporter in a single query,
     * preventing N+1 query issues and improving performance.
     *
     * @param id the task ID
     * @param organization_id the ID of the organization
     * @return an Optional containing the task with all related entities populated, empty otherwise
     */
    @EntityGraph(attributePaths = {"project", "assignee", "reporter"})
    Optional<TaskRepo> queryByIdAndOrganization_Id(Long id, Long organization_id);

    /**
     * Retrieves all tasks assigned to a specific user within an organization, with pagination.
     *
     * @param organizationId the ID of the organization
     * @param assigneeId the ID of the user assigned to the tasks
     * @param pageable pagination parameters (page number, size, sorting)
     * @return a page of tasks assigned to the user
     */
    Page<TaskRepo> findAllByOrganization_IdAndAssignee_Id(Long organizationId, Long assigneeId,
                                                          Pageable pageable);

    /**
     * Retrieves all tasks within a specific project in an organization, with pagination.
     *
     * @param organizationId the ID of the organization
     * @param projectId the ID of the project
     * @param pageable pagination parameters (page number, size, sorting)
     * @return a page of tasks in the project
     */
    Page<TaskRepo> findAllByOrganization_IdAndProject_Id(Long organizationId, Long projectId,
                                                         Pageable pageable);

    /**
     * Counts the total number of tasks in an organization.
     *
     * @param organizationId the ID of the organization
     * @return the count of tasks in the organization
     */
    long countByOrganization_Id(Long organizationId);

    /**
     * Counts tasks with a specific status in an organization.
     * Useful for dashboard statistics and progress tracking.
     *
     * @param organizationId the ID of the organization
     * @param status the task status to count
     * @return the count of tasks with the specified status
     */
    long countByOrganization_IdAndStatus(Long organizationId, TaskStatus status);
}
