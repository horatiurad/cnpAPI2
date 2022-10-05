package com.sunnyside.Scheduler.repository;
import com.sunnyside.Scheduler.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
}
