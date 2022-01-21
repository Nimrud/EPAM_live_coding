package pl.jaczewski.live_coding.patterns.command;

class ExitCommand implements Command{
    public boolean execute(String[] userInput) {
        return false;
    }
}
