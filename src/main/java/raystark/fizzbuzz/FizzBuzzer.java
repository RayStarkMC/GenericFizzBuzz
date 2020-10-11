package raystark.fizzbuzz;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public final class FizzBuzzer implements IFizzBuzzer<Integer, String> {
    private static final String SEED = "";
    private static final ValueBasedRule<Integer, String> rule = new ValueBasedRule<>(value -> value.equals(SEED), String::valueOf);
    private final IFizzBuzzer<Integer, String> fizzBuzzer;

    public FizzBuzzer(@NotNull List<FizzBuzzRule> transformRules) {
        var list = Stream.concat(
            transformRules.stream(),
            Stream.of(rule)
        ).collect(toList());

        fizzBuzzer = new ReducingFizzBuzzer<>(list, SEED);
    }

    @Override
    public <V extends Collection<String>> @NotNull V applyFizzBuzz(@NotNull Collection<Integer> source, @NotNull Collector<String, ?, V> collector) {
        return fizzBuzzer.applyFizzBuzz(source, collector);
    }
}
