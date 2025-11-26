import java.text.MessageFormat;

public class P5_4 {

    static abstract class MessageBuilder {
        protected abstract String getTitle();
        protected abstract String getBody();

        public String buildMessage() {
            return MessageFormat.format(
                    "제목: {0}\n내용: {1}",
                    getTitle(),
                    getBody()
            );
        }
    }

    static class WelcomeMessage extends MessageBuilder {
        @Override
        protected String getTitle() {
            return "환영합니다";
        }

        @Override
        protected String getBody() {
            return "시스템에 오신 것을 환영합니다.";
        }
    }

    static class AlertMessage extends MessageBuilder {
        @Override
        protected String getTitle() {
            return "경고";
        }

        @Override
        protected String getBody() {
            return "주의가 필요한 상황입니다.";
        }
    }

    public static void main(String[] args) {
        MessageBuilder welcome = new WelcomeMessage();
        MessageBuilder alert = new AlertMessage();

        System.out.println(welcome.buildMessage());
        System.out.println();
        System.out.println(alert.buildMessage());
    }
}
