package lesson9.chain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SushiPrepare {
    public enum Steps {
        TAKEORDER,
        PREPARE,
        DELIVERY,
        ACCEPTPAYMENT
    }

    private final Set steps = new HashSet();

    public SushiPrepare(Steps... steps) {
        this.steps.addAll(Arrays.asList(steps));
    }

    public Set getSteps() {
        return steps;
    }
}
