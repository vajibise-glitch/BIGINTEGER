package Rational;

import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    // Default constructor
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    // Constructor with specified numerator and denominator
    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = (denominator.compareTo(BigInteger.ZERO) > 0 ? BigInteger.ONE : new BigInteger("-1"))
                .multiply(numerator).divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }

    // Get numerator
    public BigInteger getNumerator() {
        return numerator;
    }

    // Get denominator
    public BigInteger getDenominator() {
        return denominator;
    }

    // Addition
    public Rational add(Rational secondRational) {
        BigInteger n = (numerator.multiply(secondRational.getDenominator()))
                .add(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // Subtraction
    public Rational subtract(Rational secondRational) {
        BigInteger n = (numerator.multiply(secondRational.getDenominator()))
                .subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // Multiplication
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // Division
    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE))
            return numerator.toString();
        else
            return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Rational) {
            Rational o = (Rational) other;
            return this.subtract(o).getNumerator().equals(BigInteger.ZERO);
        }
        return false;
    }

    @Override
    public int compareTo(Rational o) {
        BigInteger result = this.subtract(o).getNumerator();
        return result.compareTo(BigInteger.ZERO);
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }
}