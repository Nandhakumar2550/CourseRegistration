package com.example.courseRegistrationSystem.Controller;

import com.example.courseRegistrationSystem.Model.Course;
import com.example.courseRegistrationSystem.Model.CourseRegistry;
import com.example.courseRegistrationSystem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ={"http://localhost:5500","http://127.0.0.1:5500/"})
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("courses")
    public List<Course> availableCourse(){
        return courseService.availableCourse();
    }

    @GetMapping("courses/enrolled")
    public List<CourseRegistry> enrolledStudent(){
        return courseService.enrolledStudent();
    }

    @PostMapping("courses/register")
    public String enrollCourse(@RequestParam("name") String name,
                               @RequestParam("emailId") String emailId,
                               @RequestParam("courseName") String courseName){
        courseService.enrollCourse(name,emailId,courseName);
        return "Congratulation "+name+" Enrollment Successful for " + courseName;
    }

}
