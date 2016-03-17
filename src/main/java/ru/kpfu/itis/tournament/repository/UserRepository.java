package ru.kpfu.itis.tournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.tournament.model.User;

/**
 * Created by etovladislav on 10.03.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmail(String login);
}
