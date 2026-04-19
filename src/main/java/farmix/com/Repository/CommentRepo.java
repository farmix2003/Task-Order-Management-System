package farmix.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Comment entities.
 *
 * This repository provides CRUD operations and custom query methods for comments
 * associated with tasks. Comments enable collaboration by allowing users to discuss
 * and provide feedback on specific tasks within a project.
 */
@Repository
public interface CommentRepo extends JpaRepository<farmix.com.Entity.Comment, Long> {

    /**
     * Retrieves all comments for a specific task within an organization, ordered by creation date.
     *
     * @param taskId the ID of the task to fetch comments for
     * @param organizationId the ID of the organization (for multi-tenancy/security)
     * @return a list of comments ordered by creation time (earliest first)
     */
    List<CommentRepo> findAllByTask_IdAndOrganization_IdOrderByCreatedAtAsc(Long taskId, Long organizationId);

}
