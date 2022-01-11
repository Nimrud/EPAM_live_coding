package pl.jaczewski.live_coding.patterns.factory;

class OSFactory implements OS{

    public OSFactory() {
    }

    @Override
    public String getDescription() {
        return null;
    }

    public static OS getOSType(OSType osType) {
        return osType.getConstructor();
    }
}
