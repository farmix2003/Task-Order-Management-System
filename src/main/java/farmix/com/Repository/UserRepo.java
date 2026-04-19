package farmix.com.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing User entities.
 *
 * This repository provides CRUD operations and custom query methods for user accounts.
 * Users are members of organizations and can have various roles (ADMIN, MANAGER, EMPLOYEE).
 * It supports email-based lookups, organization-scoped user queries, and pagination
 * for user management operations.
 */
@Repository
public interface UserRepo extends JpaRepository<farmix.com.Entity.User, Long> {

    /**
     * Retrieves a user by their email address (case-insensitive).
     * Email is the unique identifier for login and authentication.
     *
     * @param email the email address to search for
     * @return an Optional containing the user if found, empty otherwise
     */
    Optional<UserRepo> findByEmailIgnoreCase(String email);

    /**
     * Checks if a user with the given email already exists (case-insensitive).
     * Used to enforce email uniqueness during user registration and updates.
     *
     * @param email the email address to check
     * @return true if a user with this email exists, false otherwise
     */
    boolean existsByEmailIgnoreCase(String email);

    /**
     * Retrieves a user by their ID within a specific organization.
     * Ensures users can only access members of their own organization.
     *
     * @param id the user ID
     * @param organizationId the ID of the organization
     * @return an Optional containing the user if found in the organization, empty otherwise
     */
    Optional<UserRepo> findByIdAndOrganization_id(Long id, Long organizationId);

    /**
     * Checks if a user with the given ID exists within an organization.
     *
     * @param id the user ID
     * @param organizationId the ID of the organization
     * @return true if the user exists in the organization, false otherwise
     */
    boolean existsByIdAndOrganization_Id(Long id, Long organizationId);

    /**
     * Retrieves all users in a specific organization with pagination support.
     *
     * @param organizationId the ID of the organization
     * @param pageable pagination parameters (page number, size, sorting)
     * @return a page of users in the organization
     */
    Page<UserRepo> findAllByOrganization_Id(Long organizationId, Pageable pageable);

}
