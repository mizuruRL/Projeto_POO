import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Abstract class responsible for handling streams of data. Methods use generic Object data types,
 * so casting is necessary.
 * @author André Dias (190221068) e Tomás Barroso (190221029)
 * @version 1.0
 */
public abstract class RWFile {

    /**
     * Static method that handles the creation of a text file (*.txt), with the desired content. Subsequent usages
     * overrides the file (if said file already exists), and thus all of the previous content will be lost.
     * @param fileName Name of .txt file.
     * @param textToSave String content to save on .txt file.
     */
    public static void printToFile(String fileName, String textToSave) {
        if(textToSave == null || textToSave.isEmpty())
            throw new IllegalArgumentException("Text to save cannot be null or empty.");
        Charset utf8 = StandardCharsets.UTF_8;
        try {
            Files.write(Paths.get(fileName+ ".txt"), textToSave.getBytes(utf8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Static method that handles the serialization and stream of any object's data into a .bin file.
     * Subsequent usages overrides the file (if said file already exists),
     * and thus all of the previous content will be lost.
     * @param fileName Name of .bin file.
     * @param obj Object to save.
     */
    public static void saveData(String fileName, Object obj) {
        if(obj == null)
            throw new IllegalArgumentException("Data must exist.");
        try (FileOutputStream fout = new FileOutputStream(fileName + ".bin");
             ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Static method that handles the de-serialization and stream of any .bin data into an object.
     * @param fileName Name of .bin file to search.
     */
    public static Object loadData(String fileName) {
        Object data = null;
        try (FileInputStream fin = new FileInputStream(fileName + ".bin");
             ObjectInputStream ois = new ObjectInputStream(fin)) {
            data = ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to locate data.\n");
        } catch (EOFException e) {
            System.out.println("EndOfFile\n");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound\n");
        }
        return data;
    }
}
