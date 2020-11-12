package com.sts;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sts.DAO.UserRepository;
import com.sts.entities.User;

@SpringBootApplication
public class FirststsprojectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirststsprojectApplication.class, args);
		
		UserRepository userrepository = context.getBean(UserRepository.class);
		
//		//Create User
//		User user = new User();
//		//Enter Data
//		user.setName("Abhinanv Bajpai");
//		user.setCity("Kanpur");
//		user.setStatus("Business");
//		
//		User save = userrepository.save(user);
//		
//	     System.out.println(save);
		
		
		
		//save multiple object
//		User user1 = new User();
//		//Enter Data
//		user1.setName("Ankur Bajpai");
//		user1.setCity("Kanpur");
//		user1.setStatus("Job");
//		
//		
//		User user2 = new User();
//		//Enter Data
//		user2.setName("Manisha Bajpai");
//		user2.setCity("Kanpur");
//		user2.setStatus("Doctor");
//		
//		List<User> result = List.of(user1,user2);
//		
//		Iterable<User> fresult = userrepository.saveAll(result);
//		
//		fresult.forEach(user->{
//			System.out.println(user);
//		});
		
		
		//Updat
		
//		Optional<User> optional = userrepository.findById(4);
//		
//		User user = optional.get();
//		System.out.println(user);
//		
//		user.setName("Anubhav Bajpai");
//		User save = userrepository.save(user);
//		
//		System.out.println(save);
//		
//		userrepository.deleteById(4);
		
		
		//Custom Finder methods
		List<User> findByName = userrepository.findByName("Abhinandan Bajpai");
		

		findByName.forEach(e->System.out.println(e));
		
		List<User> findByNameAndStatus = userrepository.findByNameAndStatus("Ankur Bajpai", "Job");
		
		findByNameAndStatus.forEach(e->System.out.println(e));
		
		List<User> userByJob = userrepository.getUserByJob();
		
		userByJob.forEach(e->System.out.println(e));
		
	}

}
