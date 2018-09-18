package demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import demo.model.User;
import demo.model.UserRole;
import demo.repository.UserRepository;
import demo.repository.UserRolesRepository;

@SpringBootApplication
public class VisitasApplication {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRolesRepository userRolesRepository;
	
	@PostConstruct
	public void init()
	{
		User user = new User();
		user.setUserName("Rager");
		user.setEnabled(1);
		user.setEmail("rager@prueba.com");
		user.setPassword("$2a$04$63zLfCv0TW.qriY3JQh2yeQY6qibd3J.NHNNG4e7rRQK2/UpDzHDi");
		userRepository.save(user);
		
		user = new User();
		user.setUserName("Jared");
		user.setEnabled(1);
		user.setEmail("jared@prueba.com");
		user.setPassword("$2a$04$8No6KXlrG1GOp1Kqro3EcuTCJ9Oxi08HiyTXz5en.9D40R0cIwwAy");
		userRepository.save(user);
		
		UserRole userRole = new UserRole();
		userRole.setUserid(userRepository.findByUserName("Rager").getUserid());
		userRole.setRole("ROLE_ADMIN");		
		userRolesRepository.save(userRole);
		
		userRole = new UserRole();
		userRole.setUserid(userRepository.findByUserName("Rager").getUserid());
		userRole.setRole("ROLE_USER");		
		userRolesRepository.save(userRole);
		
		userRole = new UserRole();
		userRole.setUserid(userRepository.findByUserName("Jared").getUserid());
		userRole.setRole("ROLE_USER");		
		userRolesRepository.save(userRole);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(VisitasApplication.class, args);
	}
}
