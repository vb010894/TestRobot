package com.severstal.infocom.TestingRobot.Core.Configuration.Beans;

import com.severstal.infocom.TestingRobot.Core.Configuration.Startup.StartupSetting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

/**
 * Конфигурационный класс.
 */
@Configuration
@PropertySource("file:${user.dir}/"
        + "AppConfigs"
        + "/TestRobot"
        + "/FrameWorks"
        + "/FrameworksPaths"
        + ".properties")
public class BeansLoader {

    /**
     * Путь для драйвера.
     * <p>Для изменения полей по умолчанию<br>
     * смотри resources/FrameworksPaths.properties</p>
     */
    @Value("${WinDriver.path}")
    private String driverPath;

    /**
     * Команда для запуска драйвера.
     */
    @Value("${WinDriver.startCommand}")
    private String driverStartCommand;

    /**
     * URL хаба.
     */
    @Value("${WinDriver.hub}")
    private String driverLocation;

    /**
     * Бин старта APPIUM и WinDriver.
     * @return Класс
     */
    @Bean("startupSetting")
    @Scope("prototype")
    public StartupSetting startSetting() {
        return new StartupSetting(
                driverPath,
                driverStartCommand,
                driverLocation);
    }

}
