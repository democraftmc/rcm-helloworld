package group.aelysium.rustyconnector.core.lib.module;

import org.jetbrains.annotations.NotNull;

public abstract class ExternalModuleBuilder<T extends Module> {
    public abstract void bind(@NotNull Object kernel, @NotNull T instance);
    
    @NotNull
    public abstract T onStart(@NotNull Context context) throws Exception;
}
