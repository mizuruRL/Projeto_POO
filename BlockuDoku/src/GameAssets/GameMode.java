package GameAssets;

/**
 * Class responsible for handling the game types (difficulties).
 * @author André Dias (190221068) e Tomás Barroso (190221029)
 * @version 1.0
 */
public enum GameMode {
    BASIC,ADVANCED;

    @Override
    public String toString() {
        String text = "";
        switch(this){
            case BASIC: text =  "Basic Mode";break;
            case ADVANCED: text =  "Advanced Mode";break;
        }
        return text;
    }
}
