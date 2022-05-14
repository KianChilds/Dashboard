package frc.robot.subsystems.driveTrain;

import com.fasterxml.jackson.annotation.JsonProperty;

import frc.robot.common.motorFactory.TalonFXConfig;

public class DriveTrainConfig {
    @JsonProperty("right-lead-motor")
    public TalonFXConfig rightLead = new TalonFXConfig(2);
    @JsonProperty("right-follow-motor")
    public TalonFXConfig rightFollow = new TalonFXConfig(3);
}
