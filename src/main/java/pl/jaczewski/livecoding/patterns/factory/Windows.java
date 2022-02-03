package pl.jaczewski.livecoding.patterns.factory;

class Windows implements OS{
    private static String description;

    @Override
    public String getDescription() {
        return description;
    }
}
