import org.firmata4j.I2CDevice;
import org.firmata4j.Pin;
import	org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.MonochromeCanvas;
import org.firmata4j.ssd1306.SSD1306;
import	java.io.IOException;
import	java.util.Timer;

public	class	LabGPart4	{
    //	Pin	definitions	(assuming	Nano	or	UNO)
    static final int	A0	=	14;	//	Potentiometer
    static final int	A2	=	16;	//	Sound
    static final int	D6	=		6;	//	Button
    static final int	D4	= 4;	//	LED
    static final byte	I2C0	=	0x3C;	//	OLED	Display
    public static void	main(String[]	args)
            throws	InterruptedException,	IOException
    {
        var	myArduinoBoard	=	new	FirmataDevice("COM3");	//	Change	to	your	serial	port
        myArduinoBoard.start();
        myArduinoBoard.ensureInitializationIsDone();
        var myLED = myArduinoBoard.getPin(14);
        myLED.setMode(Pin.Mode.OUTPUT);

        I2CDevice myOledDisplay = myArduinoBoard.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 theOledObject = new SSD1306(myOledDisplay, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515

        var task = new potTask(10, myArduinoBoard);
        new Timer().schedule(task, 0, 1000);

        while (true){
            double sample = 0;
            String value = String.valueOf(task.getPotValue());
            int number = Math.toIntExact(task.getPotValue())/10;
            theOledObject.getCanvas().drawString(0, 0, value);
            theOledObject.getCanvas().drawHorizontalLine(0, 50, number, MonochromeCanvas.Color.BRIGHT);
            theOledObject.display();
            Thread.sleep(2000);
        }
    }
}