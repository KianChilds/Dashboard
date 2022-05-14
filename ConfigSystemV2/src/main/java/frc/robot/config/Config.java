package frc.robot.config;

import com.fasterxml.jackson.annotation.JsonIgnore;

import frc.robot.subsystems.driveTrain.DriveTrainConfig;

public class Config {
    public int version = 1;
    @JsonIgnore
    public RuntimeConfig runtimeConfig;
    
    public DriveTrainConfig driveTrainConfig = new DriveTrainConfig();
}
