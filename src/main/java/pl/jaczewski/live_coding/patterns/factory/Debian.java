package pl.jaczewski.live_coding.patterns.factory;

class Debian implements OS{
    private static String description;

    @Override
    public String getDescription() {
        return description;
    }
}
