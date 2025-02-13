import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import java.io.IOException;
import org.firmata4j.IODevice;
import org.firmata4j.ssd1306.SSD1306;
import org.firmata4j.I2CDevice;

public class LabHPart2
{
    public static void main(String[] args)
            throws IOException, InterruptedException {
        IODevice arduinoObject = new FirmataDevice("COM3");
        arduinoObject.ensureInitializationIsDone(); // make sure connection is good to board.


        try {
            var buttonObject = arduinoObject.getPin(6);
            buttonObject.setMode(Pin.Mode.INPUT);
            var potentiometer = arduinoObject.getPin(14);
            potentiometer.setMode(Pin.Mode.ANALOG);
            I2CDevice i2cObject = arduinoObject.getI2CDevice((byte) 0x3C);
            SSD1306 LED = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64);
            LED.init();
            LED.getCanvas().write("Press to begin");
            LED.display();
            arduinoObject.addEventListener(new PotentiometerListener(LED, buttonObject, potentiometer));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Program Failed");
        }
    }
}
