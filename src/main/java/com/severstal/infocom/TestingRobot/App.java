package com.severstal.infocom.TestingRobot;

import com.severstal.infocom.TestingRobot.Core.Configuration.Beans.BeansLoader;
import com.severstal.infocom.TestingRobot.Core.Configuration.Startup.Startup;
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
        Startup setting = (Startup) context.getBean("startupSetting");
        try {
            setting.startWinDriver();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        System.out.println(setting.getDriverLocation());
        System.out.println(System.getProperty("user.dir"));
    }
}
