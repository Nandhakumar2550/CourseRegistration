package com.example.courseRegistrationSystem.Service;

import com.example.courseRegistrationSystem.Model.Course;
import com.example.courseRegistrationSystem.Model.CourseRegistry;
import com.example.courseRegistrationSystem.Repository.CourseRegistryRepo;
import com.example.courseRegistrationSystem.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;
    @Autowired
    CourseRegistryRepo courseRegistryRepo;

    public List<Course> availableCourse() {
        return courseRepo.findAll();
    }

    public List<CourseRegistry> enrolledStudent() {
        return courseRegistryRepo.findAll();
    }

    public void enrollCourse(String name, String emailId, String courseName) {
        CourseRegistry courseRegistry=new CourseRegistry(name,emailId,courseName);
        courseRegistryRepo.save(courseRegistry);
    }
}
