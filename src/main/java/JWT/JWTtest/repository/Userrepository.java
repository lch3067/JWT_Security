package JWT.JWTtest.repository;

import JWT.JWTtest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Userrepository extends JpaRepository<User,Integer> {
    Boolean existsByStride(String username);

    User findByStride(String Stride);

    @Query(value = "SELECT * FROM user ORDER BY userid DESC", nativeQuery = true)
    List<User> findAllDesc();
}
