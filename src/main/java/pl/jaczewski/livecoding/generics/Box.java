package pl.jaczewski.livecoding.generics;

class Box<T> {
    private T object;

    void set(T object) { this.object = object; }
    T get() { return object; }
}
