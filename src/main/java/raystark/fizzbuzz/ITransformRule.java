package raystark.fizzbuzz;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface ITransformRule<T, R> {
    ITransformRule<?, ?> IDENTITY = (t, v) -> v;

    @NotNull
    static <T, R> ITransformRule<T, R> identity() {
        //IDENTITYは渡されたvalueをそのまま返すため
        @SuppressWarnings("unchecked")
        var identity = (ITransformRule<T, R>) IDENTITY;
        return identity;
    }

    @NotNull
    R applyRule(@NotNull T source, @NotNull R value);

    @NotNull
    default ITransformRule<T, R> andThen(@NotNull ITransformRule<T, R> after) {
        return (source, value) -> after.applyRule(source, this.applyRule(source, value));
    }
}
