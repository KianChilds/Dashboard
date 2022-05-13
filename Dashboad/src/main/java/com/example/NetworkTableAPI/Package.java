package com.example.NetworkTableAPI;

import java.util.HashMap;
import java.util.Set;

import com.example.reports.Motor;
import com.example.reports.StatusReport;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Package {
    private StatusReport curStatus = new StatusReport();
    private HashMap<Integer, Motor> motors = new HashMap<>();

    public Package(){
        for(int i =0; i< 10; i++){
            motors.put(i, new Motor(i));
        }
    }

    @CrossOrigin
    @GetMapping("status")
    public StatusReport getStatus(){
        return curStatus;
    }

    @CrossOrigin
    @GetMapping("motor/ids")
    public Set<Integer> getIds(){
        return motors.keySet();
    }

    @CrossOrigin
    @GetMapping("motor/{id}")
    public Motor getMotor(@PathVariable Integer id){
        return motors.get(id);
    }
}
