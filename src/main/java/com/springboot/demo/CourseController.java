package com.springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;
    @RequestMapping(value="/courses", method=RequestMethod.GET)
    public List<Course> courseList(){
    return  courseService.courseList();

}    @RequestMapping(value ="/courses", method = RequestMethod.POST)
    public void createCourse(@RequestBody Course course) {
        courseService.createCourse(course);

    }
    @RequestMapping(value="/courses/{id}", method=RequestMethod.GET)
    public Course getCourse(@PathVariable int id){

                return courseService.getCourse(id);
            }
    @RequestMapping(value="/courses/{id}", method=RequestMethod.DELETE)
    public void deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);

    }
    @RequestMapping(value ="/courses", method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course){
        courseService.updateCourse(course);
    }
public void findCourse(){
        
}
    }

