package com.avengers.studentManagement;
//Inside this class we will write our API's (Application Programming Interfaces)
// Spring boot helps/allows us to make REST(Representation State Transfer)full API (Stateless API)

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//An annotation that we need to mention above the class to tells the compiler that
//this class is going to used as REST API and that annotation is @RestController

@RestController //very first @annotation we need to write while making an API
public class StudentController {
    Map<Integer,Student> db = new HashMap<>();
     //4 major function that our studentManagementApplication should have:
    // CRUD :- Create , Read , Update , Delete ->(Students)

    //get Information
    //1. On which attribute we would search a student -> on admission no.(Primary key)

    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("q") int admnNo){
        return db.get(admnNo); //assuming that a student will definitely be present in my map
    }

    //Adding the information
    //1. return type is String because I'm going to display a message "Student added successfully"
    //2. Either I take four attributes of student class or the Student class itself
    // as a parameter
    //3. @PostMapping is an Annotation which create an API that create a student/add the student
    //4. Since This is a post API so I need to map it with an URL & inside this annotation
    // we define our end point
    //
    @PostMapping("/add_Student")
    public String addStudent(@RequestBody Student student){ //this function is getting the student Object
        int admnNo = student.getAdmnNo();
        db.put(admnNo,student);
        return "Student added successfully";
    }
}
