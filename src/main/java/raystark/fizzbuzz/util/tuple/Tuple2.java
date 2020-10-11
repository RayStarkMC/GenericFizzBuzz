package raystark.fizzbuzz.util.tuple;

import org.jetbrains.annotations.NotNull;

import java.util.function.BiFunction;

public interface Tuple2<T1, T2> {
    @NotNull
    T1 t1();

    @NotNull
    T2 t2();

    @NotNull
    default T1 left() {
        return t1();
    }

    @NotNull
    default T2 right() {
        return t2();
    }

    @NotNull
    default <R1> Tuple2<R1, T2> map1(@NotNull BiFunction<? super T1, ? super T2, ? extends R1> mapper) {
        return new LazyTuple2<>(() -> mapper.apply(t1(), t2()), this::t2);
    }

    @NotNull
    default <R2> Tuple2<T1, R2> map2(@NotNull BiFunction<? super T1, ? super T2, ? extends R2> mapper) {
        return new LazyTuple2<>(this::t1, () -> mapper.apply(t1(), t2()));
    }

    static <T1, T2> Tuple2<T1, T2> of(T1 t1, T2 t2) {
        return new LazyTuple2<>(() -> t1, () -> t2);
    }
}
