package frc.robot.dashboard;

import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.common.motorFactory.TalonFXConfig;
import frc.robot.config.Config;

@SpringBootApplication
@RestController
public class WebApp {
    private static Config cfg;

    public static void setConfg(Config c){
        cfg = c;
    }

    @CrossOrigin
    @GetMapping("/status")
    public Status getStatus(){
        return new Status(cfg);
    }

    @GetMapping("motorConfigs")
    @CrossOrigin
    public Map<String, TalonFXConfig> getMotorConfigs(){
        return Map.of(
            "right lead",   cfg.driveTrainConfig.rightLead,
            "right follow", cfg.driveTrainConfig.rightFollow,
            "left lead",    cfg.driveTrainConfig.leftLead,
            "left follow",  cfg.driveTrainConfig.leftFollow
        );
    }

    public class Status{
        public String matchType;
        public double matchTime;
        public String batteryName;
        public boolean ready = true;

        public Status(Config cfg){
            batteryName = cfg.runtimeConfig.batteryName;
            matchTime = DriverStation.getMatchTime();
            matchType = DriverStation.getMatchType().toString();
        }
    }
}