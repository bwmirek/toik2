package pl.edu.pwsztar.toik2.catering.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repozytorium użytkowników
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Funkcja szukająca użytkownika po nazwie
     *
     * @param username Nazwa użytkownika
     * @return Użytkownik o podanej nazwie
     */
    User findOneByUsername(String username);
}
