package frc.robot.config;

import com.fasterxml.jackson.annotation.JsonIgnore;

import frc.robot.subsystems.driveTrain.DriveTrainConfig;

public class Config {
    public int version = 1;

    public String robot = "Default";

    @JsonIgnore
    public RuntimeConfig runtimeConfig;

    @JsonIgnore
    public static boolean deskTopTesting = true;
    
    public DriveTrainConfig driveTrainConfig = new DriveTrainConfig();
}
