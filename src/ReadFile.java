
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {

        static int[] readFile(int amount) throws FileNotFoundException {
            int[] numbers = new int[amount];
            File myObj = new File("C://Users//alexa//Documents//seminar1_algo//src//numbers.txt");
            Scanner myReader = new Scanner(myObj);
            for (int i = 0; i < amount; i++) {
                String data = myReader.nextLine();
                numbers[i]= Integer.parseInt(data);
            }
            myReader.close();
            return numbers;
        }

    }


