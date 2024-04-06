package com.mkt.dev.backendspring.repository;

import com.mkt.dev.backendspring.model.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Iterable<User> findAllByBirthdayBetween(Date offset, Date limit);
    Iterable<User> findByUpdatedAtAfter(Date yesterday);

}
