package pl.jaczewski.livecoding.patterns.strategy;

class Student {
    LearningStrategy strategy;

    public Student(LearningStrategy strategy) {
        this.strategy = strategy;
    }

    void changeStrategy(LearningStrategy learningStrategy) {
        this.strategy = learningStrategy;
    }

    void learn() {
        strategy.execute();
    }
}
