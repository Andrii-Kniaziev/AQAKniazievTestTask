package com.test.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static final int SEVEN = 7;
    public static final int THREE = 3;
    public static final String VIACHESLAV = "Вячеслав";
    public static final String NOT_A_NUMBER_ERROR_MESSAGE = "Вы ввели не число.";
    public static final String COMMON_ERROR_MESSAGE = "Что то пошло не так. Перезапустите программу и попробуйте снова.";

    /**
     * If you want to run checkGreaterThan method - pass 1 into args
     * If you want to run sayHelloToName method - pass 2 into args
     * If you want to run printMultiplesOfThree method - pass 3 into args
     * */
    public static void main(String[] args) {
        Solution solution = new Solution();

        if (Integer.parseInt(args[0]) == 1) solution.checkGreaterThan(SEVEN);
        else if (Integer.parseInt(args[0]) == 2) solution.sayHelloToName(VIACHESLAV);
        else if (Integer.parseInt(args[0]) == 3) solution.printMultiplesOf(THREE);
    }

    /**
     * First task
     * */
    public void checkGreaterThan(int i) {
        System.out.println("Введите ваше число: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int toCheck = Integer.parseInt(reader.readLine());
            if (toCheck > i) {
                System.out.println("Привет");
            }
        } catch (IOException ex) {
            System.out.println(COMMON_ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            System.out.println(NOT_A_NUMBER_ERROR_MESSAGE);
        }
    }

    /**
     * Second task
     * */
    public void sayHelloToName(String name) {
        System.out.println("Введите имя: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String toCheck = reader.readLine();
            if (toCheck.equals(name)) {
                System.out.printf("Привет, %s%n", toCheck);
            } else {
                System.out.println("Нет такого имени");
            }
        } catch (IOException ex) {
            System.out.println(COMMON_ERROR_MESSAGE);
        }
    }

    /**
     * Third task
     * */
    public void printMultiplesOf(int i) {
        System.out.println("Введите числа массива через пробел, и нажмите ентер.");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String integers = reader.readLine();
            int[] arr = Arrays.stream(integers.split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.stream(arr).filter(el -> el % i == 0).forEach(System.out::println);
        } catch (IOException ex) {
            System.out.println(COMMON_ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            System.out.println(NOT_A_NUMBER_ERROR_MESSAGE);
        }
    }
}
