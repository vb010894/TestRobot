package com.severstal.infocom.TestingRobot.Core.Configuration.Startup;

import com.severstal.infocom.TestingRobot.Core.Configuration.Enums.DriverType;
import com.severstal.infocom.TestingRobot.Core.Logger.Logger;
import org.openqa.selenium.NotFoundException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс для превоначальной
 * <p>конфигурации тестировщика.</>
 * @author vd.zinovev
 * @since 1.0
 * @version 1.0
 */

public class Startup {


    /**
     * Путь для драйвера.
     * <p>Для изменения полей по умолчанию<br>
     * смотри AppConfigs
     * /TestRobot
     * /FrameWorks
     * /FrameworksPaths.properties</p>
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
    public Startup(
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
    public Startup() {
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
        Logger.setAction("Инициализация Appium");
        String command = "cmd /c start "
                + "\"\" "
                + buildLocation
                + driverPath
                + driverStartCommand;

        Logger.setAction("Запуск драйвера");
        this.startProcess(
                command,
                DriverType.Appium);
    }

    public void StartSelenium() {

    }

    private void startSeleniumHub() {

    }

    /**
     * Выполняет запуск процесса.
     * @param startCommand Комнда для запуска
     * @param type Тип драйвера для проверки запуска
     * @throws Exception Пропуск исключений
     */
    private void startProcess(
            final String startCommand,
            DriverType type)
    throws Exception {
       Runtime.
                getRuntime().
                exec(startCommand);
       Logger.setAction("Ожидание запуска");
       Thread.sleep(5000);
       if(!this.checkProcessExist(type)) {
           throw new NotFoundException("Процесс не запущен");
       } else {
           Logger.setResult("Процесс запущен успешно");
       }
    }

    /**
     * Проверка процесса.
     * @param type Тип драйвера
     * @return Запущен или нет процесс
     * @throws Exception пропуск исключений
     */
    public boolean checkProcessExist(final DriverType type)
    throws Exception {
        Process process = Runtime.getRuntime().exec("tasklist");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        process.getInputStream()));

        while (reader.readLine() != null) {
            if(reader.readLine()
                    .contains(type.value())) {
                return true;
            }
        }

        return false;
    }
}
