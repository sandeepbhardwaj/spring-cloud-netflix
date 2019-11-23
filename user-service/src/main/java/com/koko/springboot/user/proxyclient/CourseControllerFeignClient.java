package com.koko.springboot.user.proxyclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.koko.springboot.user.model.Course;

@FeignClient(value = "course-service")
public interface CourseControllerFeignClient {
	@GetMapping("/courses")
	List<Course> findAll();

	@GetMapping(path = "/courses", params = "id")
	List<Course> findAllById(@RequestParam("id") List<Long> courseIds);

	@PostMapping(path = "/courses")
	Course save(@RequestBody Course course);

	@GetMapping("/courses/{id}")
	Course findUserById(@PathVariable Long id);
}
