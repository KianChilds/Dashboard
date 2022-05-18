package frc.robot.common.motorFactory;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.MotorCommutation;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.BaseTalonPIDSetConfiguration;
import com.ctre.phoenix.motorcontrol.can.SlotConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TalonFXConfig {
    @JsonProperty("name")
    public String name = "";

    @JsonIgnore
    public final String type = "TalonFX";
    
    @JsonProperty("id")
    public int id = -1;

    @JsonProperty("invertType")
    public TalonFXInvertType invertType = TalonFXInvertType.CounterClockwise;

    @JsonProperty("neutralMode")
    public NeutralMode neutralMode = NeutralMode.Brake;

    @JsonProperty("selectedSlot")
    public int selectedSlot = 0;

    @JsonProperty("slot0")
    public SlotConfiguration slot0;

    @JsonProperty("slot1")
    public SlotConfiguration slot1;

    @JsonProperty("slot2")
    public SlotConfiguration slot2;

    @JsonProperty("slot3")
    public SlotConfiguration slot3;

    @JsonProperty("customParam0")
    public double customParam0 = 0;

    @JsonProperty("customParam1")
    public double customParam1 = 0;

    @JsonProperty("openloopRamp")
    public double openloopRamp = 0.0;

    @JsonProperty("closedloopRamp")
    public double closedloopRamp = 0.0;

    @JsonProperty("peakOutputForward")
    public double peakOutputForward = 1.0;

    @JsonProperty("peakOutputReverse")  
    public double peakOutputReverse = -1.0;

    @JsonProperty("nominalOutputForward")
    public double nominalOutputForward = 0.0;

    @JsonProperty("nominalOutputReverse")
    public double nominalOutputReverse = 0.0;

    @JsonProperty("neutralDeadband")
    public double neutralDeadband = 0.04;

    @JsonProperty("voltageCompSaturation")
    public double voltageCompSaturation = 0.0;

    @JsonProperty("voltageMeasurementFilter")
    public int voltageMeasurementFilter = 32;

    @JsonProperty("velocityMeasurementWindow")
    public int velocityMeasurementWindow = 64;
    
    @JsonProperty("forwardSoftLimitThreshold")
    public double forwardSoftLimitThreshold = 0.0;
    
    @JsonProperty("reverseSoftLimitThreshold")
    public double reverseSoftLimitThreshold = 0.0;

    @JsonProperty("motionCruiseVelocity")
    public double motionCruiseVelocity = 0.0;

    @JsonProperty("motionAcceleration")
    public double motionAcceleration = 0.0;

    @JsonProperty("motionCurveStrength")
    public int motionCurveStrength = 0;

    @JsonProperty("motionProfileTrajectoryPeriod")
    public int motionProfileTrajectoryPeriod = 0;

    @JsonProperty("feedbackNotContinuous")
    public boolean feedbackNotContinuous = false;

    @JsonProperty("remoteSensorClosedLoopDisableNeutralOnLOS")
    public boolean remoteSensorClosedLoopDisableNeutralOnLOS = false;

    @JsonProperty("clearPositionOnLimitF")
    public boolean clearPositionOnLimitF = false;

    @JsonProperty("clearPositionOnLimitR")
    public boolean clearPositionOnLimitR = false;

    @JsonProperty("clearPositionOnQuadIdx")
    public boolean clearPositionOnQuadIdx = false;

    @JsonProperty("limitSwitchDisableNeutralOnLOS")
    public boolean limitSwitchDisableNeutralOnLOS = false;

    @JsonProperty("softLimitDisableNeutralOnLOS")
    public boolean softLimitDisableNeutralOnLOS = false;

    @JsonProperty("pulseWidthPeriod_EdgesPerRot")
    public int pulseWidthPeriod_EdgesPerRot = 1;

    @JsonProperty("pulseWidthPeriod_FilterWindowSz")
    public int pulseWidthPeriod_FilterWindowSz = 1;

    @JsonProperty("trajectoryInterpolationEnable")
    public boolean trajectoryInterpolationEnable = true;

    @JsonProperty("primaryPID")
    public PID primaryPID = new PID();

    @JsonProperty("auxiliaryPID")
    public PID auxiliaryPID = new PID();
    
    @JsonProperty("forwardLimitSwitchSource")
    public LimitSwitchSource forwardLimitSwitchSource = LimitSwitchSource.Deactivated;
    
    @JsonProperty("reverseLimitSwitchSource")
    public LimitSwitchSource reverseLimitSwitchSource = LimitSwitchSource.Deactivated;
    
    @JsonProperty("forwardLimitSwitchDeviceID")
    public int forwardLimitSwitchDeviceID = 0;
    
    @JsonProperty("reverseLimitSwitchDeviceID")
    public int  reverseLimitSwitchDeviceID = 0;
    
    @JsonProperty("forwardLimitSwitchNormal")
    public LimitSwitchNormal forwardLimitSwitchNormal = LimitSwitchNormal.Disabled;
    
    @JsonProperty("reverseLimitSwitchNormal")
    public LimitSwitchNormal reverseLimitSwitchNormal = LimitSwitchNormal.Disabled;
    
    @JsonProperty("sum0Term")
    public FeedbackDevice sum0Term = FeedbackDevice.IntegratedSensor;
    
    @JsonProperty("sum1Term")
    public FeedbackDevice sum1Term = FeedbackDevice.IntegratedSensor;
    
    @JsonProperty("diff0Term")
    public FeedbackDevice diff0Term = FeedbackDevice.IntegratedSensor;
    
    @JsonProperty("diff1Term")
    public FeedbackDevice diff1Term = FeedbackDevice.IntegratedSensor;
    
    @JsonProperty("supplyCurrLimit")
    public SupplyCurrentLimitConfigurationJson supplyCurrentLimit = new SupplyCurrentLimitConfigurationJson();

    @JsonProperty("statorCurrLimit")
    public StatorCurrentLimitConfigurationJson statorCurrentLimit = new StatorCurrentLimitConfigurationJson();


    public MotorCommutation motorCommutation = MotorCommutation.Trapezoidal;
    public AbsoluteSensorRange absoluteSensorRange = AbsoluteSensorRange.Unsigned_0_to_360;

    @JsonProperty("integratedSensorOffsetDegrees")
    public double integratedSensorOffsetDegrees = 0.0;
    
    @JsonProperty("SensorInitializationStrategy")
    public SensorInitializationStrategy initializationStrategy = SensorInitializationStrategy.BootToZero;

    public TalonFXConfig(){}

    public TalonFXConfig(int id, String name){
        this.id = id;
        this.name = name;
    }

    public class PID{
        @JsonProperty("selectedFeedbackCoefficient")
        public double selectedFeedbackCoefficient = 0.0;
        @JsonProperty("selectedFeedbackSensor")
        public FeedbackDevice selectedFeedbackSensor = FeedbackDevice.IntegratedSensor;
        public BaseTalonPIDSetConfiguration convert(){
            BaseTalonPIDSetConfiguration p =new BaseTalonPIDSetConfiguration(selectedFeedbackSensor);
            p.selectedFeedbackCoefficient = selectedFeedbackCoefficient;
            return p;
        }
    }

    public class SupplyCurrentLimitConfigurationJson{
        @JsonProperty("enable")
        public boolean enable = true;
        @JsonProperty("currentLimit")
        public double currentLimit = 37.5;
        @JsonProperty("triggerThresholdCurrent")
        public double triggerThresholdCurrent = 45.0;
        @JsonProperty("triggerThresholdTime")
        public double triggerThresholdTime = 1.5;
        
        public SupplyCurrentLimitConfigurationJson(){

        }

        public SupplyCurrentLimitConfiguration convert(){
            return new SupplyCurrentLimitConfiguration(enable, currentLimit, triggerThresholdCurrent, triggerThresholdTime);

        }
    }

    public class StatorCurrentLimitConfigurationJson{
        @JsonProperty("enable")
        public boolean enable = true;
        @JsonProperty("currentLimit")
        public double currentLimit = 30.0;
        @JsonProperty("triggerThresholdCurrent")
        public double triggerThresholdCurrent = 30.0;
        @JsonProperty("triggerThresholdTime")
        public double triggerThresholdTime = 1;
        
        public StatorCurrentLimitConfigurationJson(){

        }

        public StatorCurrentLimitConfiguration convert(){
            return new StatorCurrentLimitConfiguration(enable, currentLimit, triggerThresholdCurrent, triggerThresholdTime);
        }
    }

    @JsonIgnore
    public TalonFXConfiguration getTalonConfiguration(){
        TalonFXConfiguration cfg = new TalonFXConfiguration();
        cfg.slot0 = slot0;
        cfg.slot1 = slot1;
        cfg.slot2 = slot2;
        cfg.slot3 = slot3;
        cfg.openloopRamp = openloopRamp;
        cfg.closedloopRamp = closedloopRamp;
        cfg.peakOutputForward = peakOutputForward;
        cfg.peakOutputReverse = peakOutputReverse;
        cfg.nominalOutputForward = nominalOutputForward;
        cfg.nominalOutputReverse = nominalOutputReverse;
        cfg.neutralDeadband = neutralDeadband;
        cfg.voltageCompSaturation = voltageCompSaturation;
        cfg.voltageMeasurementFilter = voltageMeasurementFilter;
        cfg.motionCruiseVelocity = motionCruiseVelocity;
        cfg.motionAcceleration = motionAcceleration; 
        cfg.motionCurveStrength = motionCurveStrength; 
        cfg.motionProfileTrajectoryPeriod = motionProfileTrajectoryPeriod; 
        cfg.feedbackNotContinuous = feedbackNotContinuous; 
        cfg.remoteSensorClosedLoopDisableNeutralOnLOS = remoteSensorClosedLoopDisableNeutralOnLOS; 
        cfg.clearPositionOnLimitF = clearPositionOnLimitF; 
        cfg.clearPositionOnLimitR = clearPositionOnLimitR; 
        cfg.clearPositionOnQuadIdx = clearPositionOnQuadIdx; 
        cfg.limitSwitchDisableNeutralOnLOS = limitSwitchDisableNeutralOnLOS; 
        cfg.softLimitDisableNeutralOnLOS = softLimitDisableNeutralOnLOS; 
        cfg.pulseWidthPeriod_EdgesPerRot = pulseWidthPeriod_EdgesPerRot; 
        cfg.pulseWidthPeriod_FilterWindowSz = pulseWidthPeriod_FilterWindowSz; 
        cfg.trajectoryInterpolationEnable = trajectoryInterpolationEnable;
        cfg.primaryPID = primaryPID.convert();
        cfg.auxiliaryPID = auxiliaryPID.convert();
        cfg.forwardLimitSwitchSource = forwardLimitSwitchSource;
        cfg.reverseLimitSwitchSource = reverseLimitSwitchSource;
        cfg.forwardLimitSwitchDeviceID = forwardLimitSwitchDeviceID;
        cfg.reverseLimitSwitchDeviceID = reverseLimitSwitchDeviceID;
        cfg.forwardLimitSwitchNormal = forwardLimitSwitchNormal;
        cfg.reverseLimitSwitchNormal = reverseLimitSwitchNormal;
        cfg.sum0Term = sum0Term;
        cfg.sum1Term = sum1Term;
        cfg.diff0Term = diff0Term;
        cfg.diff1Term = diff1Term;
        cfg.supplyCurrLimit = supplyCurrentLimit.convert();
        cfg.statorCurrLimit = statorCurrentLimit.convert();
        cfg.motorCommutation = motorCommutation;
        cfg.absoluteSensorRange = absoluteSensorRange;        
        cfg.integratedSensorOffsetDegrees = integratedSensorOffsetDegrees;
        cfg.initializationStrategy = initializationStrategy;

        return cfg; 

    }
}
