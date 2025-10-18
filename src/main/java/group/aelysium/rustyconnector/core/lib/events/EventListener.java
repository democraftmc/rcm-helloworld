package group.aelysium.rustyconnector.core.lib.events;

import java.util.function.Consumer;

public interface EventListener {
    void on(Event event, Consumer<Event> handler);
}
