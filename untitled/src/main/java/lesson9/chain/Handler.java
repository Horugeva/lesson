package lesson9.chain;

public abstract class Handler {
    protected Handler nextHandler;
    private final SushiPrepare.Steps step;

    protected Handler(SushiPrepare.Steps step) {
        this.step = step;
    }

    public abstract void prepareImpl();

    public void order(SushiPrepare prepare) {
        if (prepare.getSteps().contains(step)) {
            prepareImpl();
        }
        if (nextHandler != null) {
            nextHandler.order(prepare);
        }
    }

    public Handler setNext(Handler handler) {
        nextHandler = handler;
        return handler;
    }
}
