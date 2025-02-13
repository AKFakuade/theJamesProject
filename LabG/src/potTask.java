import org.firmata4j.IODevice;
import	org.firmata4j.Pin;
import	org.firmata4j.ssd1306.MonochromeCanvas;
import	org.firmata4j.ssd1306.SSD1306;
import	java.io.IOException;
import	java.util.Timer;
import	java.util.TimerTask;
public	class	potTask	extends	TimerTask	{
    private IODevice myArduinoBoard;

    private Pin myLed;

    private Pin myPot;

    private long samplePotValue;

    private int theVariable;

    static final int REDLED = 4; // D4

    static final int THEPOT = 14; // A0
    //	class	constructor.
    public potTask(int theVariable, IODevice myArduinoBoard) {
        this.myArduinoBoard = myArduinoBoard;
        this.theVariable = theVariable;

        this.myLed = myArduinoBoard.getPin(REDLED);
        try {
            myLed.setMode(Pin.Mode.OUTPUT);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.myPot = myArduinoBoard.getPin(THEPOT);
        try {
            myPot.setMode(Pin.Mode.ANALOG);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
        public long getPotValue() {
            return samplePotValue;
        }


    @Override
    public	void	run()	{
        samplePotValue = myPot.getValue();

        if (theVariable == 1) {
            try {
                myLed.setValue(1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            theVariable = 0;
        } else {
            try {
                myLed.setValue(0);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            theVariable = 1;
        }
    }
}