package com.dbs6339.webservice.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface UserRepositrory extends JpaRepository<User,Long> {

    @Query("SELECT u "+
            "FROM User u " +
            "ORDER BY u.id DESC")
    Stream<User> findAllDesc();
}
