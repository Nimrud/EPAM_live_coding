package pl.jaczewski.livecoding.patterns.factory;

class Debian implements OS{
    private static String description;

    @Override
    public String getDescription() {
        return description;
    }
}
