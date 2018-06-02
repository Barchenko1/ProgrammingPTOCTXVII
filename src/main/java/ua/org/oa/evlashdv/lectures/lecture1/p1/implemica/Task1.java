package ua.org.oa.evlashdv.lectures.lecture1.p1.implemica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    static int brackets(int n) { // Method to find number of brackets by given number
        int[] C = new int[n + 1];
            C[0] = 1;
            for (int i = 1; i <= n; i++) {
                C[i] = 0;
                for (int j = 0; j < i; j++)
                    C[i] += C[j] * C[i - 1 - j];
            }
            return C[n];
    }
    public static void main (String[]args){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){ // Input stream in try-catch with resources
            String in = reader.readLine(); // Read value from console
            int number = Integer.parseInt(in); // Parse number of brackets
            System.out.println("Number of brackets: " + number);
            System.out.println("Number of true bracket expressions: " + brackets(number));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("This is not a number");
        } catch (NegativeArraySizeException e){
            System.out.println("You have entered a number less than 0");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You have entered a number less than 0");
        }
    }
}