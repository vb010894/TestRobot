package com.severstal.infocom.TestingRobot.Core.Configuration.Enums;

/**
 * Тип Драйвера.
 * @author vd.zinovev
 * @version 1.0
 * @since 1.0
 */
public enum DriverType {

    /**
     * Appium.
     */
    Appium("WinAppDriver.exe"),

    /**
     * Selenium Hub.
     */
    SeleniumHub("SelleniumHub"),

    /**
     * Selenium Node.
     */
    SeleniumNode("b");

    /**
     * Текущее значение типа.
     */
    private String type;

    /**
     * Конструктор перечисления.
     * @param targetType Тип
     */
    DriverType(
            final String targetType) {
        this.type = targetType;
    }

    /**
     * Возвращает текущее значение типа.
     * @return Тип
     */
    public String value() {
        return this.type;
    }
}
