package com.example.cozycook.services;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.List;import java.util.ArrayList;import java.util.Date;import com.example.cozycook.models.User;import com.example.cozycook.repositories.UserRepository;@Servicepublic class UserService {  @Autowired  UserRepository repository;  /*  Uses UserRepository to create a new entry in the users table from the given user object.   */  public User createUser(User user) {    return this.repository.save(user); // An insert.  }  public User findMostRecentUser() {    return this.repository.findMostRecentUser();  }  /*  Uses UserRepository to find all entries in users table.   */  public List<User> findAllUsers() {    return (List<User>) this.repository.findAll();  }  /*  Uses UserRepository to find entry with the given id in users table.   */  public User findUserByUsername(String username) {    return this.repository.findUserByUsername(username);  }  public User findUserByCredentials(String username, String password) {    return this.repository.findUserByCredentials(username, password);  }  public User findUserById(Long userId) {    return this.repository.findById(userId).get();  }  /*  Uses UserRepository to update an entry from users table by reassigning the entry with the given uid.   */  public int updateUser(Long uid, User user) {    User originalUser = findUserById(uid);    if (user.getUsername() != null) {      originalUser.setUsername(user.getUsername());    }    if (user.getPassword() != null) {      originalUser.setPassword(user.getPassword());    }    if (user.getRole() != null) {      originalUser.setRole(user.getRole());    }    if (user.getEmail() != null) {      originalUser.setEmail(user.getEmail());    }    if (user.getFirstName() != null) {      originalUser.setFirstName(user.getFirstName());    }    if (user.getLastName() != null) {      originalUser.setLastName(user.getLastName());    }    this.repository.save(originalUser); // An update.    return 1;  }  /*  Uses UserRepository to delete an entry from users table by its uid.  *///  public int deleteUser(Long uid) {//    this.repository.deleteById(uid);//    return 1;//  }}