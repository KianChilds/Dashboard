package frc.robot.subsystems.driveTrain;

import com.fasterxml.jackson.annotation.JsonProperty;

import frc.robot.common.motorFactory.TalonFXConfig;
import frc.robot.config.RangeConfig;
import frc.robot.config.RangeConfig.RangeType;

public class DriveTrainConfig {
    @JsonProperty("right-lead-motor")
    public TalonFXConfig rightLead = new TalonFXConfig(2,  "Right Lead");
    
    @JsonProperty("right-follow-motor")
    public TalonFXConfig rightFollow = new TalonFXConfig(3, "Right Follow");

    @JsonProperty("left-lead-motor")
    public TalonFXConfig leftLead = new TalonFXConfig(2,  "Left Lead");
    
    @JsonProperty("left-follow-motor")
    public TalonFXConfig leftFollow = new TalonFXConfig(3, "Left Follow");

    @JsonProperty("speed")
    public RangeConfig speed = new RangeConfig(RangeType.INT, 15, 0, 20);
}
