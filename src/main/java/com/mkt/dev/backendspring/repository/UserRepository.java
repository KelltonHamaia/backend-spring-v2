package com.mkt.dev.backendspring.repository;

import com.mkt.dev.backendspring.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
