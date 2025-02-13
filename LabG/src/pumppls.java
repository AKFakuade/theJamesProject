import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;


public class pumppls
{
    static Pin mos;
    static IODevice Arduino;
    public static void main(String[] args) throws IOException {
        String portName = "COM3";

        Arduino = new FirmataDevice(portName);
        try {
            Arduino.start();
            Arduino.ensureInitializationIsDone();
            mos = Arduino.getPin(2);
            mos.setMode(Pin.Mode.OUTPUT);
            while (true) {
                mos.setValue(1);
                System.out.println("should be on rn ");
                long value = mos.getValue();
                System.out.println("is it on? " + value);
                Thread.sleep(1000);
                mos.setValue(0);
                value = mos.getValue();
                System.out.println("is it off? " + value);
            }

        }
        catch (Exception e)
        {
            System.out.println("idk");
        }

}}
