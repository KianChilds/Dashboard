package frc.robot.config;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Config {
    public int version;
    @JsonIgnore
    public RuntimeConfig runtimeConfig;

    
}
