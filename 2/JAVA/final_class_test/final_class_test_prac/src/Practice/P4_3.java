import java.util.HashMap;
import java.util.Map;

public class P4_3 {
    public interface EventHandler {
        void handle(String data) throws Exception;
    }

    public static class UnknownEventException extends Exception {
        public UnknownEventException(String name) {
            super("Unknown event: " + name);
        }
    }

    public static class EventDispatcher {
        private final Map<String, EventHandler> handlers = new HashMap<>();

        public void register(String eventName, EventHandler handler) {
            handlers.put(eventName, handler);
        }

        public void dispatch(String eventName, String data) {
            try {
                if (!handlers.containsKey(eventName))
                    throw new UnknownEventException(eventName);
                handlers.get(eventName).handle(data);
                System.out.println("EVENT SUCCESS: " + eventName);
            } catch (Exception e) {
                System.out.println("ERROR during " + eventName + ": " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        EventDispatcher dispatcher = new EventDispatcher();

        dispatcher.register("onLogin", data -> System.out.println("로그인 성공: " + data));
        dispatcher.register("onMessage", data -> System.out.println("메시지 수신: " + data));
        dispatcher.register("onError", data -> { throw new Exception("강제 에러!"); });

        dispatcher.dispatch("onLogin", "user123");
        dispatcher.dispatch("onMessage", "Hello World");
        dispatcher.dispatch("onError", "test");
        dispatcher.dispatch("onUnknown", "???");
    }
}
