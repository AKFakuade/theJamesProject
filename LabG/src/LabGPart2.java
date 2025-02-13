import org.firmata4j.I2CDevice;
import org.firmata4j.IODevice;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;

public class LabGPart2 {
    public static void main(String[] args)
            throws InterruptedException, IOException
    {
        String myUSB = "COM3";
        IODevice theArduinoObject = new FirmataDevice(myUSB);
        theArduinoObject.start();
        theArduinoObject.ensureInitializationIsDone();
        I2CDevice i2cObject = theArduinoObject.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515
        theOledObject.init();

        theOledObject.getCanvas().drawString(0, 0, "Jethro");
        theOledObject.display();
        Thread.sleep(3000);
        theOledObject.getCanvas().clear();

        theOledObject.getCanvas().drawString(0, 0, "Wignaraj");
        theOledObject.display();
        Thread.sleep(3000);
        theOledObject.getCanvas().clear();

        theOledObject.getCanvas().drawString(0, 0, "220655916");
        theOledObject.display();
        Thread.sleep(3000);
        theOledObject.getCanvas().clear();

        theArduinoObject.stop();

    }
}
