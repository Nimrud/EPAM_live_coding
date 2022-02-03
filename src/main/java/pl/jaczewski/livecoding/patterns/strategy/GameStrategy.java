package pl.jaczewski.livecoding.patterns.strategy;

class GameStrategy implements LearningStrategy {
    @Override
    public void execute() {
        System.out.println("Game strategy");
    }
}
