package pl.jaczewski.live_coding.patterns.command;

class EchoCommand implements Command {
    @Override
    public boolean execute(String[] input) {
        System.out.println(input[1]);
        return true;
    }
}
