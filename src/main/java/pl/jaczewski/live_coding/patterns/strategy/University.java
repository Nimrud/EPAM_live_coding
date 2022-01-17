package pl.jaczewski.live_coding.patterns.strategy;

class University {
    public static void main(String[] args) {
        Student student = new Student(new NetflixStrategy());
        student.learn();

        student.changeStrategy(new GameStrategy());
        student.learn();

        student.changeStrategy(new CleaningStrategy());
        student.learn();
    }
}
