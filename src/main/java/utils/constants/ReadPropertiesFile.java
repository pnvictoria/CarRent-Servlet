package utils.constants;

import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
    private Properties propertySql;
    private Properties propertyPage;
    private Properties propertiesConstant;
    private static final String sqlFileProperties = "/sqlQueries.properties";
    private static final String pagesFileProperties = "/pages.properties";
    private static final String constantsFileProperties = "/constants.properties";

    public ReadPropertiesFile() {
        try {
            propertySql = new Properties();
            propertyPage = new Properties();
            propertiesConstant = new Properties();
            propertySql.load(this.getClass().getResourceAsStream(sqlFileProperties));
            propertyPage.load(this.getClass().getResourceAsStream(pagesFileProperties));
            propertiesConstant.load(this.getClass().getResourceAsStream(constantsFileProperties));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getSqlProperty(String name) {
        return propertySql.getProperty(name);
    }

    public String getPageProperty(String name) {
        return propertyPage.getProperty(name);
    }

    public String getConstantProperty(String name) {
        return propertiesConstant.getProperty(name);
    }
}
