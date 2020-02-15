package com.severstal.infocom.TestingRobot;

import com.severstal.infocom.TestingRobot.Core.Configuration.Beans.BeansLoader;
import com.severstal.infocom.TestingRobot.Core.Configuration.Startup.StartupSetting;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BeansLoader.class);
        StartupSetting setting = (StartupSetting) context.getBean("startupSetting");
        try {
            setting.startWinDriver();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(setting.getDriverLocation());
        System.out.println(System.getProperty("user.dir"));
    }
}
