package com.severstal.infocom.TestingRobot;

import com.severstal.infocom.TestingRobot.Configuration.StartupSetting;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.sql.rowset.CachedRowSet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        FileSystemXmlApplicationContext context =
         new FileSystemXmlApplicationContext(
                 "E:\\Projects\\AppConfigs\\TestRobot\\Dependencies"
                         + "\\Dependencies.xml"
        );

        StartupSetting setting = context.getBean("Startup",
                StartupSetting.class);

        try {
            setting.startDriver();
        } catch (Exception ex) {
            //
        }
    }
}
