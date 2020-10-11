package raystark.fizzbuzz;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.stream.Collector;

public interface IFizzBuzzer<T, R> {
    @NotNull
    <V extends Collection<R>> V applyFizzBuzz(@NotNull Collection<T> source, @NotNull Collector<R, ?, V> collector);
}
