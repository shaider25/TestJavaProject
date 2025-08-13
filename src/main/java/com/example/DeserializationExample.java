package com.example;

import java.io.*;

public class DeserializationExample {
    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("object.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object obj = in.readObject(); // Unsafe deserialization
            in.close();
            fileIn.close();
            System.out.println("Deserialized object: " + obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
