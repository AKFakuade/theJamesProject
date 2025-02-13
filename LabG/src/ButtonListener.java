import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import java.io.IOException;
public class ButtonListener implements IODeviceEventListener {
    private final Pin ledPin;
    private final Pin buttonPin;
    // constructor
    ButtonListener(Pin ledPin, Pin buttonPin) {
        this.buttonPin = buttonPin;
        this.ledPin = ledPin;
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

        try{
            boolean buttonInput = buttonPin.getValue() != 0;
            if (buttonInput) {
                int value = ledPin.getValue() == 0 ? 1 : 0;
                ledPin.setValue(value);
            }

        }catch (IOException e) {
            e.printStackTrace();
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