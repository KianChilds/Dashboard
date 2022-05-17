package frc.robot.dashboard;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import frc.robot.config.Config;

@SpringBootApplication
public class WebApp {
    private static Config cfg;

    public static void setConfg(Config c){
        cfg = c;
    }
}
