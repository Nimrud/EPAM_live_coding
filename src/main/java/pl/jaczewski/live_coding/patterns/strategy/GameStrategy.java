package pl.jaczewski.live_coding.patterns.strategy;

class GameStrategy implements LearningStrategy {
    @Override
    public void execute() {
        System.out.println("Game strategy");
    }
}
