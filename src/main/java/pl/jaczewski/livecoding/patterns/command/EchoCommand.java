package pl.jaczewski.livecoding.patterns.command;

class EchoCommand implements Command {
    @Override
    public boolean execute(String[] input) {
        System.out.println(input[1]);
        return true;
    }
}
