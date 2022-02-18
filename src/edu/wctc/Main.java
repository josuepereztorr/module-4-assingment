package edu.wctc;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner keyboard = new Scanner(System.in);
    private static PaintCalculator paintCalculator = new PaintCalculator();

    public static void main(String[] args) {

        while(true) {

            printMenu();

            int selection = Integer.parseInt(keyboard.next());

            if (selection == 5) {
                System.out.println("Goodbye");
                break;
            }

            switch (selection) {
                case 1 -> createRoom();
                case 2 -> writeFile();
                case 3 -> readFile();
                case 4 -> System.out.println(paintCalculator.toString());
            }

        }


    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Add room");
        System.out.println("2. Write rooms to file");
        System.out.println("3. Read rooms from file");
        System.out.println("4. View rooms");
        System.out.println("5. Exit");
        System.out.println();
        System.out.print("Enter selection: ");
    }

    private static double promptForDimension(String dimensionName) {

        System.out.print("Enter the room's " + dimensionName + ": ");

        return Integer.parseInt(keyboard.next());
    }

    private static void createRoom() {

        double length = promptForDimension("length");
        double width = promptForDimension("width");
        double height = promptForDimension("height");

        paintCalculator.AddRoom(length, width, height);

        System.out.println("Room successfully created.");
        System.out.println();
    }

    private static void readFile() {

        File file = new File("roomlist.dat");

        if (file.exists()) {

            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

                List<Room> roomList = (List<Room>) ois.readObject();

                ois.close();

                paintCalculator.setRoomList(roomList);

                System.out.println("File read successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("The file roomlist.dat was not found or there was an error while reading the file");
        }


    }

    private static void writeFile() {

        File file = new File("roomlist.dat");

        if (file.exists()) {

            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(new FileOutputStream(file));

                oos.writeObject(paintCalculator.getRoomList());

                oos.flush();
                oos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("File written successfully!");

        } else {
            System.out.println("The file roomlist.dat was not found");
        }


    }


}
