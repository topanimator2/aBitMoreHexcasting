package net.abitmorehex;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.platform.Platform;

import java.nio.file.Path;

public class DummyAbstractions {
    /**
     * This explanation is mostly from Architectury's template project.
     * One thing I would like to add for those familiar with Hex Casting's layout:
     * this is a somewhat simpler and more intuitive (imo) way to accomplish what they accomplish with Xplat abstractions.
     * <p>
     * We can use {@link Platform#getConfigFolder()} but this is just an example of {@link ExpectPlatform}.
     * <p>
     * This must be a <b>public static</b> method. The platform-implemented solution must be placed under a
     * platform sub-package, with its class suffixed with {@code Impl}.
     * <p>
     * Example:
     * <p>
     * Expect: net.abitmorehex.DummyAbstractions#getConfigDirectory()
     * <p>
     * Actual Fabric: net.abitmorehex.fabric.DummyAbstractionsImpl#getConfigDirectory()
     * <p>
     * Actual Forge: net.abitmorehex.forge.DummyAbstractionsImpl#getConfigDirectory()
     * <p>
     * <a href="https://plugins.jetbrains.com/plugin/16210-architectury">You should also get the IntelliJ plugin to help with @ExpectPlatform.</a>
     */
    @ExpectPlatform
    public static Path getConfigDirectory() {
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }
}
