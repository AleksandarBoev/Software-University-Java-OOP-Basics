package contracts;

public interface Factory<T> {
    T create(String... args);
}
