package frc.robot.common.motorFactory;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class MotorFactory {
    public static SupplyCurrentLimitConfiguration SupplyLimit(double breakerRatedCurrent) {
      // calculated based on snap action breakers
      // https://content.vexrobotics.com/vexpro/pdf/MX5-Circuit-Breaker-Datasheet.pdf
      // https://content.vexrobotics.com/vexpro/pdf/VB3-Circuit-Breaker-Datasheet.pdf
      var enable = true;
      var currentLimit = breakerRatedCurrent * 1.25;
      var triggerThreshHoldCurrent = breakerRatedCurrent * 1.5;
      var triggerThreshHoldTime = 1.5;
      return new SupplyCurrentLimitConfiguration(
          enable, currentLimit, triggerThreshHoldCurrent, triggerThreshHoldTime);
    }
  
    public static SupplyCurrentLimitConfiguration SupplyLimit() {
      return SupplyLimit(30);
    }
  
    public static StatorCurrentLimitConfiguration CurrentLimit(double currentLimit) {
      // for now, the threshold time and trigger threshold current is not honored.
      // see:
      // https://docs.ctre-phoenix.com/en/latest/ch21_Errata.html#stator-current-limit-threshold-configs
  
      var enable = true;
      var triggerThreshHoldCurrent = currentLimit;
      var triggerThreshHoldTime = 1.0;
      return new StatorCurrentLimitConfiguration(
          enable, currentLimit, triggerThreshHoldCurrent, triggerThreshHoldTime);
    }
  
    public static StatorCurrentLimitConfiguration CurrentLimit() {
      return CurrentLimit(30);
    }
  
    public static TalonSRX createTalonSRX(int id) {
      return createTalonSRX(id, false);
    }
  
    public static TalonSRX createTalonSRX(int id, Boolean invertType) {
      var motor = new TalonSRX(id);
      motor.setNeutralMode(NeutralMode.Brake);
      motor.setInverted(invertType);
  
      // We want to set this on all morors _beacuase_ this is the mechanical value we
      // can support.
      motor.configSupplyCurrentLimit(SupplyLimit());
  
      return motor;
    }
  
  
    public static TalonFXConfiguration defaultTalonFXConfiguration() {
      var talonConfig = new TalonFXConfiguration();
      talonConfig.statorCurrLimit = CurrentLimit();
      talonConfig.supplyCurrLimit = SupplyLimit();
  
      return talonConfig;
    }
  
    public static TalonFX createTalonFX(int id, TalonFXConfig motorConfig) {
      return createTalonFX(id, motorConfig, null, null);
    }
  
    public static TalonFX createTalonFX(int id, TalonFXConfig motorConfig, TalonFX leader) {
      return createTalonFX(id, motorConfig, leader, FollowerType.PercentOutput);
    }
  
    public static TalonFX createTalonFX(
        int id, TalonFXConfig motorConfig, TalonFX leader, FollowerType followerType) {
  
      // motor object
      var motor = new TalonFX(id);
      // make sure motor is off
      motor.set(TalonFXControlMode.PercentOutput, 0);
      motor.neutralOutput();
      // set motor to factory defaults
      //motor.configAllSettings(motorConfig.talonFXConfig, Constants.CANTimeout); TODO: REPLACE LINE
  
      // set to brake mode
      motor.setNeutralMode(motorConfig.neutralMode);
      // set invert mode
      motor.setInverted(motorConfig.invertType);
  
      if (leader != null) {
        motor.follow(leader, followerType);
      }
  
      return motor;
    }
  }
  