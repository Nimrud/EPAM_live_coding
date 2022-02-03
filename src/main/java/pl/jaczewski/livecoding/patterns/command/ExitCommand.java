package pl.jaczewski.livecoding.patterns.command;

class ExitCommand implements Command{
    public boolean execute(String[] userInput) {
        return false;
    }
}
