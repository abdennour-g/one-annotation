package org.test.oneannotation;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class OneannotationApplication {
    public static void main(String[] args) {
        SpringApplication.run(OneannotationApplication.class, args);
    }

    @Bean
    CommandLineRunner start(Task1Repository ts1, Task2Repository ts2, Task3Repository ts3) {
        return args -> {
            List.of(new Task1(null, "aa1"), new Task1(null, "bb1"), new Task1(null, "cc1")).forEach(task1 -> {
                ts1.save(task1);
                System.out.println(task1);
            });
            List.of(new Task2(null, "aa2"), new Task2(null, "bb2"), new Task2(null, "cc2")).forEach(task2 -> {
                ts2.save(task2);
                System.out.println(task2);
            });
            List.of(new Task3(null, "aa3"), new Task3(null, "bb3"), new Task3(null, "cc3")).forEach(task3 -> {
                ts3.save(task3);
                System.out.println(task3);
            });
            System.out.println("done !");
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

