package edu.course.lab03;

public class PriceCalculator {
    private final DiscountPolicy policy;

    public PriceCalculator(DiscountPolicy policy) {
        if (policy == null) {
            throw new IllegalArgumentException("policy must not be null");
        }
        this.policy = policy;
    }

    public double calculate(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("price must be non-negative");
        }
        return policy.apply(price);
    }
}