package farmix.com.Repository;

import farmix.com.Entity.AuditEntityType;
import farmix.com.Entity.AuditLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing AuditLog entities.
 *
 * This repository provides CRUD operations for audit logs, which track all changes
 * made to entities within the system. It helps maintain a complete audit trail for
 * compliance, debugging, and tracking purposes.
 */
@Repository
public interface AuditLogRepo extends JpaRepository<farmix.com.Entity.AuditLog, Long> {

    /**
     * Retrieves all audit logs for a specific organization with pagination support.
     *
     * @param organizationId the ID of the organization
     * @param pageable pagination parameters (page number, size, sorting)
     * @return a page of audit logs belonging to the organization
     */
    Page<AuditLog> findAllByOrganization_Id(Long organizationId, Pageable pageable);

    /**
     * Retrieves audit logs for a specific entity within an organization, with pagination.
     * This allows filtering audit logs by the type of entity (e.g., TASK, PROJECT) and
     * the specific entity ID, useful for tracking changes to particular resources.
     *
     * @param organizationId the ID of the organization
     * @param entityType the type of entity being audited (e.g., TASK, PROJECT, USER)
     * @param entityId the ID of the specific entity
     * @param pageable pagination parameters (page number, size, sorting)
     * @return a page of audit logs for the specified entity
     */
    Page<AuditLog> findAllByOrganization_IdAndEntityTypeAndEntityId(Long organizationId, AuditEntityType entityType, Long entityId,
                                                                    Pageable pageable);
}
