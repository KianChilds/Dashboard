package frc.robot.config.configHandling;

import java.util.Map;

public class RobotDetector {

    private static final Map<String, RobotName> robotMap =
      Map.of(
          "0:80:2F:24:36:BF", RobotName.MULE
          );

    public static RobotName getRobotName(String macAddress){
        //return robotMap.get(macAddress);
        return RobotName.MULE; // Convert back
    }
}
