import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import java.io.IOException;
import org.firmata4j.IODevice;
public class LabHPart1 {
    public static void main(String[] args)
            throws IOException, InterruptedException {
        String myPort = "COM3";
        IODevice arduinoObject = new FirmataDevice(myPort);
        arduinoObject.start();
        arduinoObject.ensureInitializationIsDone();
        try {

            // make sure connection is good to board.
            var ledObject = arduinoObject.getPin(4);
            ledObject.setMode(Pin.Mode.OUTPUT);

            var buttonObject = arduinoObject.getPin(6);
            buttonObject.setMode(Pin.Mode.INPUT);

            arduinoObject.addEventListener(new ButtonListener(ledObject, buttonObject));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Program Failed");
        }
    }
}