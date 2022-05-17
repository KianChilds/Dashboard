package frc.robot.subsystems.driveTrain;

import com.fasterxml.jackson.annotation.JsonProperty;

import frc.robot.common.motorFactory.TalonFXConfig;
import frc.robot.config.RangeConfig;
import frc.robot.config.RangeConfig.RangeType;

public class DriveTrainConfig {
    @JsonProperty("right-lead-motor")
    public TalonFXConfig rightLead = new TalonFXConfig(2);
    
    @JsonProperty("right-follow-motor")
    public TalonFXConfig rightFollow = new TalonFXConfig(3);

    @JsonProperty("speed")
    public RangeConfig speed = new RangeConfig(RangeType.INT, 15, 0, 20);
}
