package com.severstal.infocom.TestingRobot.StartupConfiguration;

import com.severstal.infocom.TestingRobot.Core.Configuration.Startup.Startup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Класс для тетирования <br>
 * конфигурации запуска тестеровщика.
 * @author vd.zinovev
 * @since 1.0
 * @version 1.0
 */
@DisplayName("Проверка запуска тестеровщика")
public class TestStartupConfiguration {
    /**
     * Экземпляр класса для проверки.
     */
    private static final Startup settings =
            new Startup();

    @Test
    @DisplayName("Проверка значений по умолчанию")
    public void checkDefaultValues() {
        String appiumPath = "C:\\"
                + "Program Files (x86)\\"
                + "Windows Application Driver";
        String appiumCommand = "WinAppDriver.exe "
                + "localhost "
                + "4723/wd/hub";
        String appiumHub = "http://localhost:4723"
                + "/wd/hub";
        Assertions.assertEquals(
                settings.getDriverLocation(),
                appiumHub);
        Assertions.assertEquals(
                settings.getDriverPath(),
                appiumPath);
        Assertions.assertEquals(
                settings.getDriverStartCommand(),
                appiumCommand);
    }

}
