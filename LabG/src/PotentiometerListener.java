import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;
public class PotentiometerListener implements IODeviceEventListener {
    private final SSD1306 oledPin;
    private final Pin buttonPin;
    private final Pin potentiometerPin;

    // constructor
    PotentiometerListener(SSD1306 oledPin, Pin buttonPin, Pin potentiometer) {
        this.buttonPin = buttonPin;
        this.oledPin = oledPin;
        this.potentiometerPin = potentiometer;

        // do the same for ledPin here.
    }
    // Define the four Listener methods.
    // Three are empty (not used)
    // Only onPinChange() is completed.
    // Define how onPinChange responds to an event.
    @Override
    public void onPinChange(IOEvent event) {
        // Return right away if the even isn't from the
        if (event.getPin().getIndex() != buttonPin.getIndex()) {
            return;
        }
        // What is the current LED output value?
        // (use this.ledPin here and get its value)
        // Invert the LED.
        // If it's currently 1, make it 0. And vice versa.-

        // you can use this.ledPin in here.

        double potIn = potentiometerPin.getValue();
        boolean buttonInput = buttonPin.getValue() != 0;
        if (buttonInput) {
            oledPin.clear();
            oledPin.getCanvas().drawString(0,0,"Value is " + potIn);
            oledPin.display();
        }



    }

    @Override
    public void onStart(IOEvent event) {}
    @Override
    public void onStop(IOEvent event) {}
    @Override
    public void onMessageReceive(IOEvent event, String message) {

    }
}
