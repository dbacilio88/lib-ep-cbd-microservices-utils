package pe.mil.microservices.utils.dtos.commons;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

@ToString
@Data
public class CommonApplicationInfo implements Serializable {

    private static final long serialVersionUID = -1276000973435690134L;

    @Value("${configMap.message:message not available}")
    private String configMapCheck;

    @Value("${entityUuid:entityUuid not available}")
    private String entityUuid;

    @Value("${spring.application.name:name not available}")
    private String applicationName;

    @Value("${spring.application.version:version not available}")
    private String applicationVersion;

    @Value("${spring.version:version not available}")
    private String springBootVersion;

    @Value("${configurationDomainPath:configurationDomainPath not available}")
    private String multicoreDomainPath;

    @Value("${hazelcastYmlPath:hazelcastYmlPath not available}")
    private String hazelcastYmlPath;

    private String userHome;

    private String osArch;

    private String javaVendor;

    private String systemRoot;

    public CommonApplicationInfo() {
        userHome = System.getProperty("user.home");
        osArch = System.getProperty("os.arch");
        javaVendor = System.getProperty("java.vendor");
        systemRoot = System.getenv("SystemRoot");
    }
}
