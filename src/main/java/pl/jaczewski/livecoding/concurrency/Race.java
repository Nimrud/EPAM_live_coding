package pl.jaczewski.livecoding.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Race {

    private static final int NUMBER_OF_LOOPS = 72;
    private static final int DISTANCE = 250000;
    private final Car[] cars;
    private Result firstPlace;
    private Result secondPlace;
    private Result thirdPlace;
    private long start;

    private final ExecutorService executor;
    private final Lock lock = new ReentrantLock();

    public Race(Car[] cars) {
        this.cars = cars;
        executor = Executors.newFixedThreadPool(cars.length);
    }

    public static void main(String[] args) {
        Car[] cars = {
                new Car("Lightning McQueen"),
                new Car("The King"),
                new Car("Chick Hicks"),
        };

        Race race = new Race(cars);
        try {
            race.start();
            System.out.printf("""
            1. %s
            2. %s
            3. %s%n""", race.firstPlace, race.secondPlace, race.thirdPlace);
        } catch (InterruptedException e) {
            System.err.println("Race interrupted.");
        }
    }

    private void start() throws InterruptedException {
        for (Car car : cars) {
            CountDownLatch latch = new CountDownLatch(3);
            executor.submit(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                car.drive(NUMBER_OF_LOOPS, DISTANCE, Race.this);
            });
            // 3...
            latch.countDown(); // 2...
            latch.countDown(); // 1...
            start = System.currentTimeMillis();
            latch.countDown(); // 0...
        }
        executor.shutdown();
        if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
            executor.shutdownNow();
        }
    }

    public void finish(Car car) {
        Result result = new Result(car, System.currentTimeMillis() - start);
        lock.lock();
        try {
            if (firstPlace == null) {
                firstPlace = result;
            } else if (secondPlace == null) {
                secondPlace = result;
            } else if (thirdPlace == null) {
                thirdPlace = result;
            }
        } finally {
            lock.unlock();
        }
    }

    private record Result(Car car, long time) {

        @Override
        public String toString() {
            return "%s [%.5f s]".formatted(car, time/1000d);
        }
    }
}
