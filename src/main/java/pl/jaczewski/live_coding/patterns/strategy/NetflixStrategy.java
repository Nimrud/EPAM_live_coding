package pl.jaczewski.live_coding.patterns.strategy;

class NetflixStrategy implements LearningStrategy {
    @Override
    public void execute() {
        System.out.println("Netflix strategy");
    }
}
