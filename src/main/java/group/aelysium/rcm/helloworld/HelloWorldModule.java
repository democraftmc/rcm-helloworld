package group.aelysium.rcm.helloworld;

import group.aelysium.rustyconnector.core.lib.events.Event;
import group.aelysium.rustyconnector.core.lib.events.EventListener;
import group.aelysium.rustyconnector.core.lib.lang.Component;
import group.aelysium.rustyconnector.core.lib.module.Context;
import group.aelysium.rustyconnector.core.lib.module.ExternalModuleBuilder;
import group.aelysium.rustyconnector.core.lib.module.Module;
import group.aelysium.rustyconnector.core.lib.serviceable.Service;
import group.aelysium.rustyconnector.proxy.ProxyKernel;
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
        public void bind(@NotNull Object kernel, @NotNull HelloWorldModule instance) {
            if (!(kernel instanceof ProxyKernel)) {
                return;
            }
            ProxyKernel proxyKernel = (ProxyKernel) kernel;
            EventListener eventListener = proxyKernel.services().search(EventListener.class);
            
            eventListener.on(Event.PROXY_STARTED, event -> {
                System.out.println("HelloWorld module detected proxy started event!");
            });
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
