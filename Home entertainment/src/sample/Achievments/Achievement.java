package sample.Achievments;

import sample.Player.Sprite;

public class Achievement extends Sprite {

    private String type;
    private String unlockingText;

    Achievement(String type, String unlockingText) {
        this.setType(type);
        this.setUnlockingText(unlockingText);
    }

    public final String getType() {
        return this.type;
    }

    private void setType(String type) {
        this.type = type;
    }

    final String getUnlockingText() {
        return this.unlockingText;
    }

    private void setUnlockingText(String unlockingText) {
        this.unlockingText = unlockingText;
    }
}