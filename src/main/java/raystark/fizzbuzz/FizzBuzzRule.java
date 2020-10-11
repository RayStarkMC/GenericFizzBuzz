package raystark.fizzbuzz;

import org.jetbrains.annotations.NotNull;

public final class FizzBuzzRule implements ITransformRule<Integer, String> {
    private final ITransformRule<Integer, String> rule;

    private FizzBuzzRule(int divisor, @NotNull String text) {

        rule = new SourceBasedRule<>(source -> source % divisor == 0, s -> s+text);
    }

    public static FizzBuzzRule of(int divisor, @NotNull String text) {
        return new FizzBuzzRule(divisor, text);
    }

    @Override
    public @NotNull String applyRule(@NotNull Integer source, @NotNull String value) {
        return rule.applyRule(source, value);
    }
}
