package com.example.cozycook.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cozycook.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
  @Query(value="SELECT * FROM users WHERE username=:username", nativeQuery = true)
  public User findUserByUsername(@Param("username") String username);

  @Query(value="SELECT * FROM users WHERE username=:username and password=:password", nativeQuery = true)
  public User findUserByCredentials(@Param("username") String username, @Param("password") String password);

  @Query(value="SELECT * FROM users ORDER BY id DESC LIMIT 1", nativeQuery = true)
  public User findMostRecentUser();
}