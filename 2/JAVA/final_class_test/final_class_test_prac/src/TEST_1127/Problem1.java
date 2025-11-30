package TEST_1127;

import java.util.*;

abstract class Sensor {

    protected String[] values;

    public Sensor(String[] values) {
        this.values = values;
    }

    public abstract double compute();
}

class TempSensor extends Sensor {

    public TempSensor(String[] values) {
        super(values);
    }

    public double compute() {
        long sum = 0;

        for (String s : values) {
            sum += s.hashCode();
        }

        long result = sum / values.length;
        return (double) result;
    }
}

class PressureSensor extends Sensor {

    public PressureSensor(String[] values) {
        super(values);
    }

    public double compute() {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String value : values) {
            int hashCode = value.hashCode();

            if (hashCode > max) {
                max = hashCode;
            }
            if (hashCode < min) {
                min = hashCode;
            }
        }
        return (double) (max - min);
    }
}

public class Problem1 {
    public static void main(String[] args) {

        Sensor[] sensors = new Sensor[2];

        sensors[0] = new TempSensor(new String[]{"red", "blue", "green", "yellow"});
        sensors[1] = new PressureSensor(new String[]{"alpha", "beta", "gamma"});

        double t = sensors[0].compute();
        double p = sensors[1].compute();

        double result;//지수표현?

        if (t > p) {
            result = t * p;
        }
        else {
            result = Math.abs(t - p);
        }

        System.out.println(result);
    }
}