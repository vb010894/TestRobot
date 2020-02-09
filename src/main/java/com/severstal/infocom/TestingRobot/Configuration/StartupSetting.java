package com.severstal.infocom.TestingRobot.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Класс для превоначальной
 * <p>конфигурации тестировщика.</>
 * @author vd.zinovev
 * @since 1.0
 * @version 1.0
 */
@Component("Startup")
@Scope("prototype")
@Configuration()
@PropertySource("file:E:\\"
        + "Projects\\"
        + "AppConfigs\\"
        + "TestRobot\\"
        + "FrameWorks\\"
        + "FrameworksPaths.properties")
public class StartupSetting {


    /**
     * Путь для драйвера.
     * <p>Для изменения полей по умолчанию<br>
     * смотри resources/FrameworksPaths.properties</p>
     */
    @Value("${Appium.WinDriver.path}")
    private String driverPath;

    /**
     * Команда для запуска драйвера.
     */
    @Value("${Appium.WinDriver.startCommand}")
    private String driverStartCommand;

    /**
     * URL хаба.
     */
    @Value("${Appium.WinDriver.hub}")
    private String driverLocation;

    /**
     * Конструктор для <br>
     * пользовательских настроек.
     * @param customDriverPath Путь до драйвера
     * @param customDriverCommand Команда для запуска
     * @param customDriverLocation URL хаба
     */
    public StartupSetting(
            final String customDriverPath,
            final String customDriverCommand,
            final String customDriverLocation
            ) {
        this.driverLocation = customDriverLocation;
        this.driverPath = customDriverPath;
        this.driverStartCommand = customDriverCommand;
    }

    /**
     * Конструктор по умолчанию.
     */
    public StartupSetting() {
        // Do nothing
    }

    /**
     * Возвращает значение пути до драйвера.
     * @return Путь
     */
    public String getDriverPath() {
        return this.driverPath;
    }

    /**
     * Возвращает значение <br>
     * команды для запуска.
     * @return Команда
     */
    public String getDriverStartCommand() {
        return this.driverStartCommand;
    }

    /**
     * Возвращает значение URL хаба.
     * @return URL
     */
    public String getDriverLocation() {
        return this.driverLocation;
    }

    public void startDriver() throws Exception {
        StringBuilder command = new StringBuilder();
        command.append(driverPath)
                .append("\\")
                .append(driverStartCommand);

        Runtime.
                getRuntime().
                exec("cmd /c start \"\" E:\\Projects\\AppConfigs\\TestRobot"
                        + "\\Scripts\\runAppium.bat");

    }
}
