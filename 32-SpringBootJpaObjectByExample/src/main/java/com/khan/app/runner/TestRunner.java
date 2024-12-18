package com.khan.app.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.khan.app.entity.Course;
import com.khan.app.repo.CourseRepo;
@Component
public class TestRunner implements CommandLineRunner{

	@Autowired
	private CourseRepo courseRepo;
	@Override
	public void run(String... args) throws Exception {
		
		
		Course course1 = Course.builder().id(1001).name("SBMS12").batch("SBMS").faculty("Ashok").price(123.03).build();
		Course course2= Course.builder().id(1002).name("SBMS13").batch("SBMS").faculty("SRINIVAS").price(2343.23).build();
		Course course3 = Course.builder().id(1003).name("SBMS14").batch("SBMS").faculty("SRK").price(1232897.03).build();
		Course course4 = Course.builder().id(1004).name("SBMS15").batch("JRTP").faculty("RAVI").price(324123.03).build();
		Course course5 = Course.builder().id(1005).name("SBMS16").batch("JRTP").faculty("CHANDU").price(123123.03).build();
		Course course6 = Course.builder().id(1006).name("SBMS17").batch("JAVA").faculty("KHAN").price(924782123.03).build();
		Course course7 = Course.builder().id(1007).name("SBMS18").batch("ANGULAR").faculty("Ashok").price(123.03).build();
		Course course8 = Course.builder().id(1008).name("SBMS19").batch("REACT").faculty("Ashok").price(123.03).build();
		Course course9 = Course.builder().id(1009).name("SBMS10").batch("WEB").faculty("Ashok").price(123.03).build();
		Course course10 = Course.builder().id(1010).name("SBMS11").batch("SBMS").faculty("Ashok").price(123.03).build();
		List<Course> of = List.of(course1,course2,course3,course4,course5,course6,course7,course8,course9,course10);
		courseRepo.saveAll(of);
		
		Course course11 = Course.builder().faculty("Ashok").build();
		Example<Course> of2 = Example.of(course11);
		List<Course> findby = courseRepo.findAll(of2);
		findby.forEach(System.out::println);
	}

}
