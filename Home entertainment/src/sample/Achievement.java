package sample;

/**
 * Created by cvetan on 2/15/2017.
 */
public class Achievement extends Sprite {

    public String type = null;
    public String unlockingText = null;

    public Achievement(String type, String unlockingText)
    {
        this.type = type;
        this.unlockingText = unlockingText;
    }
}
