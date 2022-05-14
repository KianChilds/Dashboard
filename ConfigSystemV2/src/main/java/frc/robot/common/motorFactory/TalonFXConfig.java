package frc.robot.common.motorFactory;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TalonFXConfig {
    public String name = "";
    public int id = -1;
    @JsonProperty("invertType")
    public TalonFXInvertType invertType = TalonFXInvertType.CounterClockwise;
    public NeutralMode neutralMode = NeutralMode.Brake;

    public TalonFXConfig(){}

    public TalonFXConfig(int id){
        this.id = id;
    }
}
