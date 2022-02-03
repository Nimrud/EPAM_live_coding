package pl.jaczewski.livecoding.generics;

class Pair<F, S> {
    private F first;
    private S second;

    void set(F o1, S o2) {
        this.first = o1;
        this.second = o2;
    }

    F getFirst() { return first; }
    S getSecond() { return second; }
}
