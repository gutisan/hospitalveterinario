package com.example.hospitalveterinario;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class Holamundo {
    @RequestMapping("/")
    public String hola() {
        return "Hola mundo";

    }

    
}
