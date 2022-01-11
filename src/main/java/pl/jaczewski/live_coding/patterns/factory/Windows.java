package pl.jaczewski.live_coding.patterns.factory;

class Windows implements OS{
    private static String description;

    @Override
    public String getDescription() {
        return description;
    }
}
