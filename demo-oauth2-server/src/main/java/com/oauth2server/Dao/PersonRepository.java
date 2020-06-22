package com.oauth2server.Dao;

import com.oauth2server.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findPersonByEmail(String email);
}
