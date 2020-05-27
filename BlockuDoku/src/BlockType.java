public enum BlockType {
    I, Q, T, L, J, S, Z, I1, I2, I3, Lm, LM, TE, QE;

    char content[][];

    BlockType() {
        this.content = new char[3][3];
    }

    public char[][] getContent(BlockType type, GameMode mode){
        if(mode == GameMode.BASICMODE){
            switch(type){
                case I:  content[0][0] = '#';
                         content[0][1] = '#';
                         content[0][2] = '#';
                         content[0][3] = '#';
                    break;
                case Q:
                    break;
                case T:
                    break;
                case L:
                    break;
                case J:
                    break;
                case S:
                    break;
                case Z:
                    break;
            }
        }
        return content;
    }

    @Override
    public String toString() {
        String text = "Bloco ";
        switch (this) {
            case I:  text += "I\n";printBlock();break;
            case Q:  text += "Q\n";printBlock();break;
            case T:  text += "T\n";printBlock();break;
            case L:  text += "L\n";printBlock();break;
            case J:  text += "J\n";printBlock();break;
            case S:  text += "S\n";printBlock();break;
            case Z:  text += "Z\n";printBlock();break;
            case I1: text += "I1\n";printBlock();break;
            case I2: text += "I2\n";printBlock();break;
            case I3: text += "I3\n";printBlock();break;
            case Lm: text += "L - mínimo\n";printBlock();break;
            case LM: text += "L - máximo\n";printBlock();break;
            case TE: text += "T Estendido\n";printBlock();break;
            case QE: text += "Q Estendido\n";printBlock();break;
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

    public void printContent(){
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[i].length; j++) {
                System.out.print(content[i][j]);
            }
            System.out.println();
        }
    }
}
