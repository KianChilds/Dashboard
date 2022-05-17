package frc.robot.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RangeConfig {
    @JsonProperty("type")
    public RangeType type;

    @JsonProperty("min")
    public double min;

    @JsonProperty("max")
    public double max;

    @JsonProperty("default")
    public double def;

    @JsonProperty("value")
    public double value;

    @JsonProperty("increment")
    public double increment;

    public RangeConfig(RangeType type, double def, double min, double max){
        if(type == RangeType.INT){
            increment = 1;
        }else{
            increment = 0.01;
        }

        this.type = type;
        this.def = def;
        this.value = def;
        this.min = min;
        this.max = max;
    }


    public enum RangeType{
        INT,
        DOUBLE
    }
}
