package group.aelysium.rcm.helloworld;

import group.aelysium.rustyconnector.common.events.EventManager;
import group.aelysium.rustyconnector.common.modules.ExternalModuleBuilder;
import group.aelysium.rustyconnector.common.modules.Module;
import group.aelysium.rustyconnector.proxy.ProxyKernel;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HelloWorldModule implements Module {
    
    @Override
    public void close() throws Exception {
        System.out.println("HelloWorld module is shutting down. Goodbye!");
    }

    @Override
    public @Nullable Component details() {
        return null;
    }

    public static class Builder extends ExternalModuleBuilder<HelloWorldModule> {
        @Override
        public void bind(@NotNull ProxyKernel kernel, @NotNull HelloWorldModule instance) {
            try {
                kernel.fetchModule("EventManager").onStart(e -> {
                    EventManager eventManager = (EventManager) e;
                    System.out.println("HelloWorld module registered with EventManager!");
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @NotNull
        @Override
        public HelloWorldModule onStart(@NotNull Context context) throws Exception {
            System.out.println("Hello World from RustyConnector Module!");
            
            HelloWorldModule module = new HelloWorldModule();
            return module;
        }
    }
}
