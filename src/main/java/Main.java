import grocerythings.GroceryList;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void writeOutputToFile(String text){
        File file = new File("output.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            //close resources
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
//        System.out.println(output);
        GroceryList grocery = JerkSONParser.dejerkify(output);
//        System.out.println(grocery.toString());
        HashMap receipt = OutputShover.bagItUp(grocery);
//        System.out.println(receipt);
        String textToWrite = OutputShover.printReceipt(receipt);
//        System.out.println(textToWrite);
        writeOutputToFile(textToWrite);
    }
}
