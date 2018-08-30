package interfaces;

public interface Factory<T> {
    T create(String... args);
}
