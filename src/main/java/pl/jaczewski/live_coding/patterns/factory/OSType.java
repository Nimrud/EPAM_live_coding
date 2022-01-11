package pl.jaczewski.live_coding.patterns.factory;

import java.util.function.Supplier;

public enum OSType {
    WINDOWS_OS(Windows::new),
    MAC_OS(Mac::new),
    DEBIAN_OS(Debian::new);

    OS getConstructor() {
        return os.get();
    }

    OSType(Supplier<OS> os) {
        this.os = os;
    }

    private Supplier<OS> os;
}
