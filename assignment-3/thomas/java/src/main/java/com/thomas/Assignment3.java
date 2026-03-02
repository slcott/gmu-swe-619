package com.thomas;

public class Assignment3 {

    public static void secondFunc() throws Exception {
        throw new Exception("Test error in secondFunc");
    }

    public static void firstFunc() throws Exception {
        try {
            secondFunc();
        } catch (Exception e) {
            throw new Exception("Test error in firstFunc");
        }
    }

    public static void modFirstFunc() throws Exception {
        try {
            secondFunc();
        } catch (Exception e) {
            throw new Exception("Test error in modFirstFunc", e);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Starting firstFunc error handling ---");
        try {
            firstFunc();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("Cause: " + e.getCause());
            System.out.println("Stack Trace:");
            e.printStackTrace(System.out);
        }
        System.out.println("--- End of firstFunc error handling ---\n");

        System.out.println("--- Starting modFirstFunc error handling ---");
        try {
            modFirstFunc();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("Cause: " + e.getCause());
            System.out.println("Stack Trace:");
            e.printStackTrace(System.out);
        }
        System.out.println("--- End of modFirstFunc error handling ---");
    }
}
