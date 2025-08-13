package com.example;

import java.io.*;

public class CommandInjectionExample {
    public static void main(String[] args) {
        String userInput = "test.txt; rm -rf /"; // Simulated malicious input
        String command = "cat " + userInput;

        try {
            Process process = Runtime.getRuntime().exec(command); // Command injection
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
