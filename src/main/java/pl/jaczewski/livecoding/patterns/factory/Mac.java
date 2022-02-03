package pl.jaczewski.livecoding.patterns.factory;

class Mac implements OS{
    private static String description;

    @Override
    public String getDescription() {
        return description;
    }
}
