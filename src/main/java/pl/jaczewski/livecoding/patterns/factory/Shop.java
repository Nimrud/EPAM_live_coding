package pl.jaczewski.livecoding.patterns.factory;

class Shop {
    public static void main(String[] args) {
        System.out.println(OSFactory.getOSType(OSType.WINDOWS_OS).getClass());
        System.out.println(OSFactory.getOSType(OSType.DEBIAN_OS).getClass());
        System.out.println(OSFactory.getOSType(OSType.MAC_OS).getClass());
    }

}
