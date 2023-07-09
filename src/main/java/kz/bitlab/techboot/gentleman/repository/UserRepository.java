package kz.bitlab.techboot.gentleman.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.techboot.gentleman.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findAllByPermissions(String permission);
    void deleteAllPermissionsById(Long id);

}
