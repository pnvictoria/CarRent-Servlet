package utils.constants;

import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
    private Properties sqlProperties;
    private Properties pagesProperties;
    private Properties constantsProperties;
    private static final String sqlFileProperties = "/sqlQueries.properties";
    private static final String pagesFileProperties = "/pages.properties";
    private static final String constantsFileProperties = "/constants.properties";

    public ReadPropertiesFile() {
        try {
            sqlProperties = new Properties();
            pagesProperties = new Properties();
            constantsProperties = new Properties();
            sqlProperties.load(this.getClass().getResourceAsStream(sqlFileProperties));
            pagesProperties.load(this.getClass().getResourceAsStream(pagesFileProperties));
            constantsProperties.load(this.getClass().getResourceAsStream(constantsFileProperties));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getSqlProperty(String name) {
        return sqlProperties.getProperty(name);
    }

    public String getPageProperty(String name) {
        return pagesProperties.getProperty(name);
    }

    public String getConstantProperty(String name) {
        return constantsProperties.getProperty(name);
    }
}
