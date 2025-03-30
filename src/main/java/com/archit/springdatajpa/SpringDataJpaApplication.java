package com.archit.springdatajpa;

import com.archit.springdatajpa.Repository.StudentRepo;
import com.archit.springdatajpa.models.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

        StudentRepo repo=context.getBean(StudentRepo.class);

        Student s1=context.getBean(Student.class);
        Student s2=context.getBean(Student.class);
        Student s3=context.getBean(Student.class);

        s1.setRollNumber(1001);
        s1.setMarks(88);
        s1.setName("Ayush");

        s2.setRollNumber(1002);
        s2.setMarks(78);
        s2.setName("Akash");

        s3.setRollNumber(1003);
        s3.setMarks(94);
        s3.setName("Archit");
        System.out.println("Hello");

        repo.save(s1);
        repo.save(s2);
        repo.save(s3);
        Optional<Student> optionalStudent=repo.findById(1004);
        System.out.println(optionalStudent.orElse(new Student()));
        //System.out.println(repo.findById(1002));
        System.out.println(repo.findAll());
        System.out.println(repo.findByName("Archit"));

    }

}
