public class P5_1 {

    interface RobotAction {
        void execute();
    }

    static abstract class AbstractRobot {
        protected String name;
        protected int battery;

        public AbstractRobot(String name, int battery) {
            this.name = name;
            this.battery = battery;
        }

        public void perform(RobotAction action) {
            action.execute();
        }

        protected void consumeBattery(int amount) {
            battery -= amount;
            if (battery < 0) battery = 0;
        }
    }

    static class SmartRobot extends AbstractRobot {

        private RobotAction highPerformanceAction;
        private RobotAction lowPowerAction;

        public SmartRobot(String name, int battery,
                          RobotAction highAction,
                          RobotAction lowAction) {
            super(name, battery);
            this.highPerformanceAction = highAction;
            this.lowPowerAction = lowAction;
        }

        public void doWork() {
            if (battery >= 50) {
                perform(highPerformanceAction);
                consumeBattery(30);
            } else if (battery >= 20) {
                perform(lowPowerAction);
                consumeBattery(15);
            } else {
                System.out.println("배터리 부족, 충전 필요");
            }

            System.out.println("현재 배터리: " + battery);
        }
    }

    public static void main(String[] args) {
        SmartRobot robot = new SmartRobot(
            "Alpha-X",
            70,
            () -> System.out.println("고성능 작업 수행 중..."),
            () -> System.out.println("저전력 작업 수행 중...")
        );

        robot.doWork(); // 70 → 고성능
        robot.doWork(); // 40 → 저전력
        robot.doWork(); // 25 → 저전력
        robot.doWork(); // 10 → 부족
    }
}
