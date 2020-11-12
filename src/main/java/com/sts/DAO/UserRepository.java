package com.sts.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sts.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public List<User> findByName(String name);
	
	public List<User> findByNameAndStatus(String name, String status);
	
	@Query(value="select * from User", nativeQuery = true)
	public List<User> getUserByJob();

}
