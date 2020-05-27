public enum BlockType {
    I, Q, T, L, J, S, Z, I1, I2, I3, Lm, LM, TE, QE;

    @Override
    public String toString() {
        String text = "Bloco ";
        switch (this) {
            case I:  text += "I\n";break;
            case Q:  text += "Q";break;
            case T:  text += "T";break;
            case L:  text += "L";break;
            case J:  text += "J";break;
            case S:  text += "S";break;
            case Z:  text += "Z";break;
            case I1: text += "I1";break;
            case I2: text += "I2";break;
            case I3: text += "I3";break;
            case Lm: text += "L - mínimo";break;
            case LM: text += "L - máximo";break;
            case TE: text += "T Estendido";break;
            case QE: text += "Q Estendido";break;
        }
        return text;
    }

    public void printBlock(){
        switch (this) {
            case I:  System.out.println("#");System.out.println("#");System.out.println("#");System.out.println("#");
            break;
            case Q:  System.out.println("##");System.out.println("##");
                break;
            case T:  System.out.println("###");System.out.println(" # ");
                break;
            case L:  System.out.println("#");System.out.println("#");System.out.println("##");
                break;
            case J:  System.out.println(" #");System.out.println(" #");System.out.println("##");
                break;
            case S: System.out.println(" ##");System.out.println("## ");
                break;
            case Z:  System.out.println("##");System.out.println(" ##");
                break;
            case I1: System.out.println("#");
                break;
            case I2: System.out.println("#");System.out.println("#");
                break;
            case I3: System.out.println("#");System.out.println("#");System.out.println("#");
                break;
            case Lm: System.out.println("#");System.out.println("##");
                break;
            case LM: System.out.println("#");System.out.println("#");System.out.println("###");
                break;
            case TE: System.out.println("###");System.out.println(" # ");System.out.println(" # ");
                break;
            case QE: System.out.println("###");System.out.println("###");System.out.println("###");
                ;break;
        }
    }
}
