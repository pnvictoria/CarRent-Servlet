package utils;

import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
    private Properties propertySql;
    private Properties propertyPageMapping;
    private Properties propertiesConstant;
    private Properties propertiesCommands;
    private static final String sqlFileProperties = "/properties/sqlQueries.properties";
    private static final String pageMappingFileProperties = "/properties/page-mapping.properties";
    private static final String constantsFileProperties = "/properties/constants.properties";
    private static final String commandsFileProperties = "/properties/commands.properties";

    public ReadPropertiesFile() {
        try {
            propertySql = new Properties();
            propertyPageMapping = new Properties();
            propertiesConstant = new Properties();
            propertiesCommands = new Properties();
            propertySql.load(this.getClass().getResourceAsStream(sqlFileProperties));
            propertyPageMapping.load(this.getClass().getResourceAsStream(pageMappingFileProperties));
            propertiesConstant.load(this.getClass().getResourceAsStream(constantsFileProperties));
            propertiesCommands.load(this.getClass().getResourceAsStream(commandsFileProperties));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getSqlProperty(String name) {
        return propertySql.getProperty(name);
    }

    public String getPageProperty(String name) {
        return propertyPageMapping.getProperty(name);
    }

    public String getConstantProperty(String name) {
        return propertiesConstant.getProperty(name);
    }

    public String getCommandsProperty(String name) {
        return propertiesCommands.getProperty(name);
    }
}
