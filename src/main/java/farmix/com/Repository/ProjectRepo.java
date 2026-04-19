package farmix.com.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing Project entities.
 *
 * This repository provides CRUD operations and custom query methods for projects.
 * Projects represent collections of tasks within an organization and are scoped
 * to specific organizations for multi-tenancy support. It provides paginated queries
 * and organizational isolation for data security.
 */
@Repository
public interface ProjectRepo extends JpaRepository<farmix.com.Entity.Project, Long> {

    /**
     * Retrieves a project by its ID within a specific organization.
     *
     * @param id the project ID
     * @param organizationId the ID of the organization (for multi-tenancy/security)
     * @return an Optional containing the project if found, empty otherwise
     */
    Optional<ProjectRepo> findByIdAndOrganization_Id(Long id, Long organizationId);

    /**
     * Retrieves all projects for a specific organization with pagination support.
     *
     * @param organizationId the ID of the organization
     * @param pageable pagination parameters (page number, size, sorting)
     * @return a page of projects belonging to the organization
     */
    Page<ProjectRepo> findAllByOrganization_Id(Long organizationId, Pageable pageable);

    /**
     * Checks if a project with the given ID exists within an organization.
     *
     * @param id the project ID
     * @param organizationId the ID of the organization
     * @return true if the project exists in the organization, false otherwise
     */
    boolean existsByIdAndOrganization_Id(Long id, Long organizationId);

    /**
     * Checks if a project with the given name already exists in an organization.
     * Used to enforce unique project names per organization.
     *
     * @param name the project name
     * @param organizationId the ID of the organization
     * @return true if a project with this name exists in the organization, false otherwise
     */
    boolean existsByNameAndOrganization_Id(String name, Long organizationId);

}
