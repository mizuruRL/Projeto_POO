import java.util.ArrayList;
import java.util.Random;

public class Block {
    BlockType type;
    Random random;
    ArrayList<Block> playableBlocksList;
    int randomNumber;
    public Block() {
        random = new Random();
        playableBlocksList = new ArrayList<>();
        randomNumber = 0;
    }
    public Block(BlockType type) {
        this.type = type;
        random = new Random();
        playableBlocksList = new ArrayList<>();
        randomNumber = 0;
    }

    public Block createRandomBlock(GameMode gamemode){
        randomNumber = random.nextInt(7) + 1;
        Block block = null;
        if(gamemode == GameMode.BASICMODE){
            switch(randomNumber){
                case 1: block = new Block(BlockType.I);break;
                case 2: block = new Block(BlockType.Q);break;
                case 3: block = new Block(BlockType.T);break;
                case 4: block = new Block(BlockType.L);break;
                case 5: block = new Block(BlockType.J);break;
                case 6: block = new Block(BlockType.S);break;
                case 7: block = new Block(BlockType.Z);break;
            }
        }else{
            switch(randomNumber){
                case 1: block = new Block(BlockType.I1);break;
                case 2: block = new Block(BlockType.I2);break;
                case 3: block = new Block(BlockType.I3);break;
                case 4: block = new Block(BlockType.Lm);break;
                case 5: block = new Block(BlockType.LM);break;
                case 6: block = new Block(BlockType.TE);break;
                case 7: block = new Block(BlockType.QE);break;
            }
        }
        return block;
    }

    public void createPlayableBlocksBoard(GameMode gamemode){
        for(int i = 0; i < 3; i++){
            playableBlocksList.add(createRandomBlock(gamemode));
        }
    }

    public void printPlayableBlocksBoard(){
        System.out.println("Blocos a jogar:");
        for(Block block : playableBlocksList){
            System.out.println(block.toString());
        }
    }

    @Override
    public String toString() {
        return "" + type.toString();
    }
}
