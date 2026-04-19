package farmix.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing Organization entities.
 *
 * This repository handles CRUD operations and custom queries for organizations.
 * Organizations are the top-level entities in the system and serve as containers
 * for projects, users, tasks, and other resources. It enforces uniqueness of
 * organization names and provides lookup capabilities.
 */
@Repository
public interface OrganizationRepo extends JpaRepository<farmix.com.Entity.Organization, Long> {

    /**
     * Checks if an organization with the given name already exists (case-insensitive).
     *
     * @param name the organization name to check
     * @return true if an organization with this name exists, false otherwise
     */
    boolean existsByNameIgnoreCase(String name);

    /**
     * Retrieves an organization by its name (case-insensitive search).
     *
     * @param name the organization name to search for
     * @return an Optional containing the organization if found, empty otherwise
     */
    Optional<OrganizationRepo> findByNameIgnoreCase(String name);
}
