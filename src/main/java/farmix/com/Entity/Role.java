package farmix.com.Entity;

/**
 * Enum representing different user roles in the application.
 * Roles determine the permissions and access levels for users within an organization.
 */
public enum Role {
    /** Administrator role with full access to all features and settings */
    ADMIN,
    /** Manager role with access to manage projects and team members */
    MANAGER,
    /** Employee role with limited access to view and work on assigned tasks */
    EMPLOYEE
}
