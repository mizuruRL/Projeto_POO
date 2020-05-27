public enum GameMode {
    BASICMODE,ADVANCEDMODE;

    @Override
    public String toString() {
        String text = "";
        switch(this){
            case BASICMODE: text =  "Basic Mode";break;
            case ADVANCEDMODE: text =  "Advanced Mode";break;
            default: text = "Invali"; break;
        }
        return text;
    }
}
