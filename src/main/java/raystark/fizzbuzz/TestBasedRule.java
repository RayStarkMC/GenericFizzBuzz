package raystark.fizzbuzz;

import org.jetbrains.annotations.NotNull;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class TestBasedRule<T, R> implements ITransformRule<T, R> {
    private final BiPredicate<? super T, ? super R> tester;
    private final BiFunction<? super T, ? super R, ? extends R> transformer;

    public TestBasedRule(@NotNull BiPredicate<? super T, ? super R> tester, @NotNull BiFunction<? super T, ? super R, ? extends R> transformer) {
        this.tester = tester;
        this.transformer = transformer;
    }

    @Override
    public @NotNull R applyRule(@NotNull T source, @NotNull R value) {
        return tester.test(source, value) ? transformer.apply(source, value) :  value;
    }
}
