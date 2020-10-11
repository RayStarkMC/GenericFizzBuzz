package raystark.fizzbuzz.util.tuple;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public final class LazyTuple2<T1, T2> implements Tuple2<T1, T2> {

    private final Supplier<T1> t1;
    private final Supplier<T2> t2;

    public LazyTuple2(Supplier<T1> t1, Supplier<T2> t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    @NotNull
    @Override
    public T1 t1() {
        return t1.get();
    }

    @NotNull
    @Override
    public T2 t2() {
        return t2.get();
    }
}
