package com.example.hospitalveterinario;

import org.springframework.web.bind.annotation.RequestMapping;


public class Holamundo {
    @RequestMapping("/")
    public String hola() {
        return "Hola mundo";

    }

    
}
