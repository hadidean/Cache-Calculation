package com.icoproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Scanner;


/**
 * JavaFX CacheCalculation
 */
public class CacheCalculation extends Application {
    
    public static int mainMemoryAddressSize;
    public static int cacheMemorySize;
    public static int wordSize;
    public static int kset;
    public static String size1;
    public static String size2;
    public static String size3;
    public static int dm1;
    public static int dm2;
    public static int dm3;


    @Override
    
     // 2) Method to ask user to enter the memory and word size
    public static void getMemoryAndWordSize(Scanner input) {
        
      System.out.println("Main Memory Address Details");
      System.out.print("Digit: ");
      mainMemoryAddressSize = input.nextInt();
      input.nextLine();
      System.out.print("Size: ");
      size1 = input.nextLine();
      
      System.out.println("Cache Memory Details: ");
      System.out.print("Digit: ");
      cacheMemorySize = input.nextInt();
      input.nextLine();
      System.out.print("Size: ");
      size2 = input.nextLine();
      
      System.out.println("Word Details: ");
      System.out.print("Digit: ");
      wordSize = input.nextInt();
      input.nextLine();
      System.out.print("Size: ");
      size3 = input.nextLine();
      
      dm1 = CacheMethods.convertSize1(size1);
      dm2 = CacheMethods.convertSize2(size2);
      dm3 = CacheMethods.convertSize3(size3);
      
      System.out.println();
    }

//    public void start(Stage stage) {
//        var javaVersion = SystemInfo.javaVersion();
//        var javafxVersion = SystemInfo.javafxVersion();
//
//        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        var scene = new Scene(new StackPane(label), 640, 480);
//        stage.setScene(scene);
//        stage.show();
//    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
              
        int choice = CacheMethods.mappingMethod(input);
        switch (choice) {
            case 1:
                System.out.println("You choose Direct Mapping method");
                getMemoryAndWordSize(input);
                CacheMethods.calcDM(mainMemoryAddressSize, cacheMemorySize, wordSize,dm1, dm2,dm3);
                break;
            case 2:
                System.out.println("You choose Associative Mapping method");
                getMemoryAndWordSize(input);
                CacheMethods.calcAM(mainMemoryAddressSize, cacheMemorySize, wordSize, dm1, dm2,dm3);
                break;
            case 3:
                System.out.println("You choose Set-Associative Mapping method");
                kset = CacheMethods.getKset(input);
                getMemoryAndWordSize(input);
                CacheMethods.calcSAM(mainMemoryAddressSize, cacheMemorySize, wordSize, dm1, dm2,dm3, kset);
                break;
            default:
                System.out.println("Unexpected choice. Exiting.");
                break;
        }

        
        launch();
    }

}