package com.NetworkTableAPI;

import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Package {
    public Package(){
    }

    @CrossOrigin
    @GetMapping("status")
    public Integer getStatus(){
        return 0;
    }

    @CrossOrigin
    @GetMapping("motor/ids")
    public Set<Integer> getIds(){
        return null;
    }

    @CrossOrigin
    @GetMapping("motor/{id}")
    public Integer getMotor(@PathVariable Integer id){
        return 1;
    }
}
