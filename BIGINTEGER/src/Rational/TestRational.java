package Rational;

import java.math.BigInteger;
import java.util.Scanner;

public class TestRational {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the first rational number
        System.out.print("Enter the first rational number (numerator denominator): ");
        BigInteger num1 = input.nextBigInteger();
        BigInteger denom1 = input.nextBigInteger();
        Rational r1 = new Rational(num1, denom1);

        // Prompt the user to enter the second rational number
        System.out.print("Enter the second rational number (numerator denominator): ");
        BigInteger num2 = input.nextBigInteger();
        BigInteger denom2 = input.nextBigInteger();
        Rational r2 = new Rational(num2, denom2);

        // Display results of arithmetic operations
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        System.out.println(r2 + " is " + r2.doubleValue());


    }
}
