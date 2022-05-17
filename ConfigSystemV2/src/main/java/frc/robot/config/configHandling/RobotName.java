package frc.robot.config.configHandling;

import frc.robot.config.Config;
import frc.robot.config.RuntimeConfig;
import frc.robot.config.robots.MuleConfig;
import frc.robot.config.robots.SimConfig;

public enum RobotName {
    MULE(0),
    SIMULATION(1);
    int id;
    RobotName(int i){
        id = i;
    }

    public Config getConfig(){
        switch(id){
            case 0:
            return new MuleConfig();
            case 1:
            return new SimConfig();
            default:
            return null;
        }
    }

    public Config getConfig(RuntimeConfig rc){
        Config cfg = getConfig();
        cfg.runtimeConfig = rc;
        return cfg;
    }
}
