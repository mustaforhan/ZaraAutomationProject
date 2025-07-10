package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void writeProductInfo(String productName, String price, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("Ürün Adı: " + productName);
            writer.newLine();
            writer.write("Fiyat: " + price);
            writer.newLine();
            writer.write("---------------");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
