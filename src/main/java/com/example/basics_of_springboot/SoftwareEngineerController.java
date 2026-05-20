package com.example.basics_of_springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineer")
public class SoftwareEngineerController {

    @GetMapping
    public List<SoftwareEngineer> getEngineers(){
        return List.of(new SoftwareEngineer(1,"tanis","vsdv")
        ,new SoftwareEngineer(2,"tanishq","vsdv")      );
    }
}
