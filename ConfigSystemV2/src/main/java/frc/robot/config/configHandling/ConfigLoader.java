package frc.robot.config.configHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import frc.robot.Main;
import frc.robot.config.Config;
import frc.robot.config.RuntimeConfig;

public class ConfigLoader {
    static ObjectMapper objectMapper = new ObjectMapper();
    private static String configPath = "/home/lvuser/config.json";

    public Config getConfig(){
        RuntimeConfig rc = new RuntimeConfig((String s) -> Main.class.getResourceAsStream(s), Config.deskTopTesting);
        if(Config.deskTopTesting) configPath = "C:/Users/Kianm/Documents/GitHub/Dashboard/config.json";
        

        RobotName robotName = RobotDetector.getRobotName(rc.macAddress);

        File configFile = getConfigFile(robotName);

        // If there isn't a pre-existing config, create one
        if(configFile == null){ 
            System.out.println("No config on robot");
            Config config = createConfig(robotName, configFile, rc);
            config.runtimeConfig = rc;
            return config;
        }

        System.out.println("Loaded config from robot");
        Config config = loadConfigFromFile(configFile);
        
        if(config == null){
            return createConfig(robotName, configFile, rc);
        }

        if(config.version != robotConfigVersion(robotName.getConfig())){
            System.out.println("Robot config out of date.");
            config = createConfig(robotName, configFile, rc);
            return config;
        }
        
        config.runtimeConfig = rc;
        return config;
    }


    /**
     * Creates and saves a config to disk.
     * @param robotName - robot to create config for
     * @param configFile - location to save the config
     * @return Default config used
     */
    public Config createConfig(RobotName robotName, File configFile, RuntimeConfig rc){
        configFile = createConfigFile(robotName);
        try { // try to write default config to disk

            saveConfigToDisk(robotName.getConfig(rc), true, configFile);
        } catch (IOException e) {
            System.out.println("Couldn't make Config file.");
        }

        return robotName.getConfig();
    }

    /**
     * Get a File pointing to 
     * @return
     */
    private File createConfigFile(RobotName robotName){
        File f = new File(configPath);
        return f;
    }

    public void saveConfigToDisk(Config toSave, boolean updateVersion, File saveLoc) throws IOException{
        if(updateVersion){
            toSave.version = robotConfigVersion(toSave);
        }

        String json = configToJson(toSave);

        if(json == "") return;

        try{
            saveLoc.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
            throw e;
        }

        try(FileWriter fw = new FileWriter(saveLoc)){
            fw.write(json);
            System.out.println("Saved config to disk");
        }
    }

    private Config loadConfigFromFile(File f){
        try {
            return objectMapper.readValue(f, Config.class);
        } catch (JsonProcessingException e){
            e.printStackTrace();
            System.out.println("Couldn't read config");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int robotConfigVersion(Config config){
        return configToJson(config).hashCode();
    }

    private String configToJson(Config config){
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(config);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Get a File object pointing to the robot config
     * @param robotName - robot to get the config of
     * @return File pointing to config file, null if none can be found
     */
    private File getConfigFile(RobotName robotName){
        File f = new File(configPath);
        if(f.exists()) return f;
    
        return null;
    }
}
