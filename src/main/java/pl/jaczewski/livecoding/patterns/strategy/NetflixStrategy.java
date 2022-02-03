package pl.jaczewski.livecoding.patterns.strategy;

class NetflixStrategy implements LearningStrategy {
    @Override
    public void execute() {
        System.out.println("Netflix strategy");
    }
}
