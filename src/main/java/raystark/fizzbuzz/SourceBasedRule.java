package raystark.fizzbuzz;

import org.jetbrains.annotations.NotNull;

import java.util.function.Function;
import java.util.function.Predicate;

public final class SourceBasedRule<T, R> extends TestBasedRule<T, R> {
    public SourceBasedRule(@NotNull Predicate<? super T> sourceTester, @NotNull Function<? super R, ? extends R> transformer) {
        super((s, v) -> sourceTester.test(s), ((s, v) -> transformer.apply(v)));
    }
}
