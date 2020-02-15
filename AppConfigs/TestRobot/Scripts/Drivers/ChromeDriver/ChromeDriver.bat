echo off
cd /d "C:\Program Files\Java\jdk-13.0.1\bin\"
java -Dwebdriver.chrome.driver=E:\Projects\TestRobot\AppConfigs\TestRobot\Scripts\Drivers\ChromeDriver\chromedriver.exe -jar E:\Projects\TestRobot\AppConfigs\TestRobot\Scripts\GRID.jar -role webdriver -hub http://localhost:4444/grid/register -port 5558 -browser browserName=chrome
