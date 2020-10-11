package raystark.fizzbuzz;

import org.jetbrains.annotations.NotNull;

import java.util.function.Function;
import java.util.function.Predicate;

public final class ValueBasedRule<T, R> extends TestBasedRule<T, R> {
    public ValueBasedRule(@NotNull Predicate<? super R> valueTester, @NotNull Function<? super T, ? extends R> transformer) {
        super((s, v) -> valueTester.test(v), (s, v) -> transformer.apply(s));
    }
}
