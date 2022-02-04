package pl.jaczewski.livecoding.concurrency;

class Car {
    private final String name;
    private long distance;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void drive(int numberOfLoops, int distance, Race race) {
        for (int i = 0; i < numberOfLoops; i++) {
            for (int j = 0; j < distance; j++) {
                this.distance++;
            }
        }
        race.finish(this);
    }
}
