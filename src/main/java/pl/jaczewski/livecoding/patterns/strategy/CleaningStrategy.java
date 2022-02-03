package pl.jaczewski.livecoding.patterns.strategy;

class CleaningStrategy implements LearningStrategy {
    @Override
    public void execute() {
        System.out.println("Cleaning strategy");
    }
}
