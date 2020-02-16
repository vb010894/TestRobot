package com.severstal.infocom.TestingRobot.Core.Logger;

/**
 * Лог консоли.
 * @author vd.zinovev
 * @version 1.0
 * @since 1.0
 */
public final class Logger {

    /**
     * Скрытый конструктор класса.
     */
    private Logger() {
        // Hide constructor
    }
    /**
     * Сброс.
     */
    private static final String ANSI_RESET = "\u001B[0m";

    /**
     * Добавляет 'Действие' для логирования.
     * @param action Текст действия
     */
    public static void setAction(final String action) {

        StringBuilder builder = new StringBuilder();
        builder.append("\u001B[36m")
                .append("[Действие] ")
                .append(action)
                .append(ANSI_RESET);
        System.out.println(builder.toString());
    }

    /**
     * Добавляет 'Результат' для логирования.
     * @param result Текст результата
     */
    public static void setResult(final String result) {

        StringBuilder builder = new StringBuilder();
        builder.append("\u001B[32m")
                .append("[Результат] ")
                .append(result)
                .append(ANSI_RESET);
        System.out.println(builder.toString());
    }

    /**
     * Добавляет 'Информацию' для логирования.
     * @param information Текст информации
     */
    public static void setInformation(final String information) {
        StringBuilder builder = new StringBuilder();
        builder.append("[Информация]")
                .append(information);
        System.out.println(builder.toString());
    }

    /**
     * Добавляет 'Предупреждение'
     * для логирования.
     * @param warning Текст предупреждения
     */
    public static void setWarning(final String warning) {
        StringBuilder builder = new StringBuilder();
        builder.append("\u001B[33m")
                .append("##vso[task.logissue type=warning]")
                .append("[Предупреждение]")
                .append(warning)
                .append(ANSI_RESET);
        System.out.println(builder.toString());
    }

    /**
     * Добавляет 'Ошибку' для логирования.
     * @param error Текст ошибки
     */
    public static void setError(final String error) {
        StringBuilder builder = new StringBuilder();
        builder.append("\u001B[31m")
                .append("##vso[task.logissue type=error]")
                .append("[Ошибка]")
                .append(error)
                .append(ANSI_RESET);
        System.out.println(builder.toString());
    }

    /**
     * Добавляет 'Техническую информацию'
     * для логирования.
     * @param information Текст технической информации
     */
    public static void setTechnicalInfo(final String information) {
        StringBuilder builder = new StringBuilder();
        builder.append("\u001B[35m")
                .append("[Техническая информация]")
                .append(information)
                .append(ANSI_RESET);
        System.out.println(builder.toString());
    }
}
