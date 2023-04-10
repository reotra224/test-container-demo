package com.reotra.demo.testcontainerdemo.config;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.MySQLContainer;

public class MySQLContainerConfig extends MySQLContainer<MySQLContainerConfig>
    implements BeforeAllCallback
{

    private static MySQLContainerConfig container;
    private static String DBNAME = "sorydatabase";
    private static String USER = "root";
    private static String PWD = "letsgosory";
    private static String JDBC_URL = "letsgosory";
    private static int PORT = 3306;
    private static String MYSQL_IMAGE = "mysql:latest";
    private MySQLContainerConfig() {
        super(MYSQL_IMAGE);
    }

    public static MySQLContainerConfig getInstance() {
        if (container == null) {
            container = new MySQLContainerConfig()
                    .withDatabaseName(DBNAME)
                    .withUsername(USER)
                    .withPassword(PWD)
                    .withExposedPorts(PORT);
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        getInstance();
        container.start();
        String jdbcUrl = String.format("jdbc:mysql://localhost:%d/%s", container.getFirstMappedPort(), DBNAME);
        System.setProperty("spring.datasource.url", jdbcUrl);
    }
}
