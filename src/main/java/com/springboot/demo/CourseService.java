package com.springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;
import java.util.function.Consumer;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @RequestMapping(value="/courses", method=RequestMethod.GET)
    public List<Course> courseList(){

        List<Course> list = new ArrayList<>();
        courseRepository.findAll().forEach(new Consumer<Course>() {
            @Override
            public void accept(Course course) {
                list.add(course);
            }
        });
        return list;
    }

    @RequestMapping(value="/courses/{id}", method=RequestMethod.GET)
    public Course getCourse(int id){
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if(optionalCourse.isPresent()){
                return optionalCourse.get();
            }

        return null;
    }
    public void createCourse(Course course){
        courseRepository.save(course);
    }
    public void deleteCourse(int id){
        courseRepository.deleteById(id);
    }
    public void updateCourse(Course course){
        courseRepository.save(course);
    }

}
