package com.severstal.infocom.TestingRobot.Core.Configuration.Startup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс для превоначальной
 * <p>конфигурации тестировщика.</>
 * @author vd.zinovev
 * @since 1.0
 * @version 1.0
 */

public class StartupSetting {


    /**
     * Путь для драйвера.
     * <p>Для изменения полей по умолчанию<br>
     * смотри resources/FrameworksPaths.properties</p>
     */
    private String driverPath;

    /**
     * Команда для запуска драйвера.
     */
    private String driverStartCommand;

    /**
     * URL хаба.
     */
    private String driverLocation;

    /**
     * Хранит рабочий каталог.
     */
    private final static String buildLocation = System.getProperty("user.dir");

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

    /**
     * Запуск WinDriver.
     * @throws Exception Пропуск исключений
     */
    public void startWinDriver()
    throws Exception {
        StringBuilder command = new StringBuilder();
        command.append("cmd /c start ")
                .append("\"\" ")
                .append(buildLocation)
                .append(driverPath)
                .append(driverStartCommand);

        this.startSeleniumHub(
                command
                .toString());
    }

    /**
     * Выполняет запуск процесса.
     * @param startCommand Комнда для запуска
     * @throws Exception Пропуск исключений
     */
    private void startSeleniumHub(
            final String startCommand)
    throws Exception {
       Runtime.
                getRuntime().
                exec(startCommand);
    }
}
