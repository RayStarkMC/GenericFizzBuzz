package raystark.fizzbuzz;

import org.jetbrains.annotations.NotNull;
import raystark.fizzbuzz.util.tuple.Tuple2;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public final class ReducingFizzBuzzer<T, R> implements IFizzBuzzer<T, R> {
    private final List<ITransformRule<T, R>> transformRules;
    private final R seed;

    public ReducingFizzBuzzer(@NotNull List<ITransformRule<T, R>> transformRules, @NotNull R seed) {
        this.transformRules = Collections.unmodifiableList(transformRules);
        this.seed = seed;
    }

    @Override
    public <V extends Collection<R>> @NotNull V applyFizzBuzz(@NotNull Collection<T> source, @NotNull Collector<R, ?, V> collector) {
        return source.stream()
            .map(this::mapToTuple)
            .map(this::applyRule)
            .map(Tuple2::t2)
            .collect(collector);
    }

    @NotNull
    private Tuple2<T, R> mapToTuple(@NotNull T source) {
        return Tuple2.of(source, seed);
    }

    @NotNull
    private Tuple2<T, R> applyRule(@NotNull Tuple2<T, R> tuple) {
        return tuple.map2(transformRules.stream().reduce(ITransformRule.identity(), ITransformRule::andThen)::applyRule);
    }
}
