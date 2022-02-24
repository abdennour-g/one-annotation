package org.test.Gener;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
class MyRestController {
	Task1Repository ts1;
	Task2Repository ts2;
	Task3Repository ts3;

	@GetMapping("/t1")
	public List<Task1> getTasks1() {
		return ts1.findAll();
	}//http://localhost:2000/t1

	@GetMapping("/t2")
	public List<Task2> getTasks2() {
		return ts2.findAll();
	}//http://localhost:2000/t2

	@GetMapping("/t3")
	public List<Task3> getTasks3() {
		return ts3.findAll();
	}//http://localhost:2000/t3
}

@SpringBootApplication
public class GenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenerApplication.class, args);
	}

	@Bean
	CommandLineRunner start(Task1Repository ts1, Task2Repository ts2, Task3Repository ts3) {
		return args -> {
			Stream.of(new Task1(0, "aa1"), new Task1(0, "bb1"), new Task1(0, "cc1")).forEach(t -> {
				ts1.save(t);
				System.out.println(t);
			});
			Stream.of(new Task2(0, "aa2"), new Task2(0, "bb2"), new Task2(0, "cc2")).forEach(t -> {
				ts2.save(t);
				System.out.println(t);
			});
			Stream.of(new Task3(0, "aa3"), new Task3(0, "bb3"), new Task3(0, "cc3")).forEach(t -> {
				ts3.save(t);
				System.out.println(t);
			});
		};
	}
}

interface Task1Repository extends JpaRepository<Task1, Integer> {
}

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
class Task1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
}

interface Task2Repository extends JpaRepository<Task2, Integer> {
}

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
class Task2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
}

interface Task3Repository extends JpaRepository<Task3, Integer> {
}

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
class Task3 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
}