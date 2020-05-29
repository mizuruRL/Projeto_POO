import java.util.ArrayList;
import java.util.Random;

public enum BlockType {
    I, Q, T, L, J, S, Z, I1, I2, I3, Lm, LM, TE, QE;

    char content[][];

    BlockType() {
        this.content = new char[4][4];
    }

    public char[][] getContent(){
            switch(this){
                case I:  content[0][0] = '#';
                         content[1][0] = '#';
                         content[2][0] = '#';
                         content[3][0] = '#';
                    break;
                case Q: content[0][0] = '#';
                        content[0][1] = '#';
                        content[1][0] = '#';
                        content[1][1] = '#';
                    break;
                case T: content[0][0] = '#';
                        content[0][1] = '#';
                        content[0][2] = '#';
                        content[1][1] = '#';
                    break;
                case L: content[0][0] = '#';
                        content[1][0] = '#';
                        content[2][0] = '#';
                        content[2][1] = '#';
                    break;
                case J: content[2][0] = '#';
                        content[0][1] = '#';
                        content[1][1] = '#';
                        content[2][1] = '#';
                    break;
                case S: content[1][0] = '#';
                        content[0][1] = '#';
                        content[1][1] = '#';
                        content[0][2] = '#';
                    break;
                case Z: content[0][0] = '#';
                        content[0][1] = '#';
                        content[1][1] = '#';
                        content[1][2] = '#';
                    break;

                case I1:    content[0][0] = '#';
                    break;
                case I2:    content[0][0] = '#';
                            content[1][0] = '#';
                    break;
                case I3:    content[0][0] = '#';
                            content[1][0] = '#';
                            content[2][0] = '#';
                    break;
                case Lm:    content[0][0] = '#';
                            content[1][0] = '#';
                            content[1][1] = '#';
                    break;
                case LM:    content[0][0] = '#';
                            content[1][0] = '#';
                            content[2][0] = '#';
                            content[2][1] = '#';
                            content[2][2] = '#';
                    break;
                case TE:    content[0][0] = '#';
                            content[0][1] = '#';
                            content[0][2] = '#';
                            content[1][1] = '#';
                            content[2][1] = '#';

                    break;
                case QE:    content[0][0] = '#';
                            content[1][0] = '#';
                            content[2][0] = '#';
                            content[0][1] = '#';
                            content[1][1] = '#';
                            content[2][1] = '#';
                            content[0][2] = '#';
                            content[1][2] = '#';
                            content[2][2] = '#';
                    break;
        }
        return content;
    }


    @Override
    public String toString() {
        String text = "Bloco ";
        switch (this) {
            case I:  text += "I\n";printContent();break;
            case Q:  text += "Q\n";printContent();break;
            case T:  text += "T\n";printContent();break;
            case L:  text += "L\n";printContent();break;
            case J:  text += "J\n";printContent();break;
            case S:  text += "S\n";printContent();break;
            case Z:  text += "Z\n";printContent();break;
            case I1: text += "I1\n";printContent();break;
            case I2: text += "I2\n";printContent();break;
            case I3: text += "I3\n";printContent();break;
            case Lm: text += "L - mínimo\n";printContent();break;
            case LM: text += "L - máximo\n";printContent();break;
            case TE: text += "T Estendido\n";printContent();break;
            case QE: text += "Q Estendido\n";printContent();break;
        }
        return text;
    }

    public void printContent(){
        content = getContent();
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[i].length; j++) {
                System.out.print(content[i][j] + " ");
            }
            System.out.println();
        }
    }

}
