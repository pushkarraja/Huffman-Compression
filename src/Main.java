import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Huffman huffman = new Huffman("");

        boolean run = true, encoded = false;

        while (run) {
            printOption();
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("Enter .txt File Path :");
                String path = scanner.nextLine().replaceAll("\"", "");
                String data = getData(path);

                huffman = new Huffman(data);
                String encodedText = huffman.encode();

                System.out.println("Encoded Text : ");
                System.out.println(encodedText);
                System.out.println();
                System.out.println("Huffman Codes : ");

                huffman.printCodes();
                encoded = true;
            } else if (!encoded) {
                System.out.println("Encode before Decoding");
            } else if (option == 2) {
                System.out.println("Enter Encoded Data :");
                String encodedText = scanner.nextLine();

                String originalText = huffman.decode(encodedText);
                System.out.println();

                System.out.println("Original Text : ");
                System.out.println(originalText);
            } else if (option == 3) {
                run = false;
            } else {
                System.out.println("!!Enter Valid Option");
            }
            System.out.println();
        }
    }

    private static String getData(String path) throws FileNotFoundException {
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("\\Z");
            return scanner.next();
        } catch (FileNotFoundException f) {
            throw  new FileNotFoundException("File not Found");
        }
    }

    private static void printOption() {
        System.out.println("-----Select an Option:-----");
        System.out.println("1. Encode");
        System.out.println("2. Decode");
        System.out.println("3. Exit");
    }
}
