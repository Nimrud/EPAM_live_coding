package pl.jaczewski.live_coding.patterns.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        boolean isActive = true;
        final Scanner scanner = new Scanner(System.in);
        Map<String, Command> commands = Map.of(
                "exit", new ExitCommand(),
                "echo", new EchoCommand(),
                "copy", new CopyCommand());

        while (isActive) {
            System.out.print("% ");
            String userInput = scanner.nextLine();

            isActive = commands.get(getWords(userInput)[0]).execute(getWords(userInput));
        }
    }

    private static String[] getWords(String input) {
        return input.trim().split(" ");
    }

}
