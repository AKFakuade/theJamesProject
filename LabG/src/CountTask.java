import org.firmata4j.Pin;
import org.firmata4j.ssd1306.MonochromeCanvas;
import org.firmata4j.ssd1306.SSD1306;
import java.util.TimerTask;
public class CountTask extends TimerTask{
    private int countValue = 10;
    private final SSD1306 theOledObject;
    // Constructor for CountTask
    public CountTask(SSD1306 aDisplayObject){
        theOledObject = aDisplayObject;
    }
    @Override
    public void run() {
        String displaynum = String.valueOf(countValue);
        // Fill the OLED memory with something to draw.
        theOledObject.getCanvas().clear(); // clear contents first.
        theOledObject.getCanvas().drawString(0, 0, displaynum);
        theOledObject.display();
        countValue--;
        if (countValue == -1)
        {
            countValue = 10;
        }
    }
}