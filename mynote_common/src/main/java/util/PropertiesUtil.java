package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Properties;

public class PropertiesUtil {

    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    //属性文件的路径
    static String profilepath = "system.properties";
    /**
     * 采用静态方法
     */
    private static Properties props = new Properties();

    static {
        try {
            props = PropertiesLoaderUtils.loadProperties(new EncodedResource(new ClassPathResource(profilepath), "UTF-8"));
        } catch (Exception e) {
            logger.error("读取配置文件{}失败！", profilepath, e);
            System.exit(-1);
        }
    }

    public static String IMAGE_PATH() {
        return props.getProperty("image_path");
    }
}
