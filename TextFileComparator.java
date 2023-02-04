package com.turedurenaru;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileComparator {
    public static void main(String[] args) throws IOException {
        String file1 = "file1.txt";
        String file2 = "file2.txt";

        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();

        int lineNumber = 1;
        boolean areFilesEqual = true;

        while (line1 != null || line2 != null) {
            if (line1 == null || line2 == null) {
                areFilesEqual = false;
                break;
            } else if (!line1.equalsIgnoreCase(line2)) {
                areFilesEqual = false;
                break;
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();
            lineNumber++;
        }

        if (areFilesEqual) {
            System.out.println("Files are equal.");
        } else {
            System.out.println("Files are not equal. They differ at line " + lineNumber);
        }

        reader1.close();
        reader2.close();
    }
}
