package group.aelysium.rustyconnector.proxy;

import group.aelysium.rustyconnector.core.lib.events.EventListener;

public interface ProxyKernel {
    Services services();
    
    interface Services {
        <T> T search(Class<T> clazz);
    }
}
