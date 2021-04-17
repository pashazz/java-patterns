package io.github.pashazz.patterns.behavioural.chain;

import static java.lang.String.format;

public abstract class Handler {
    protected Handler successor;

    public Handler getSuccessor() {
        return successor;
    }

    public Handler setSuccessor(Handler successor) {
        this.successor = successor;
        return successor; // chain it like x.setSuccessor(y).setSuccessor(z)
    }

    public void processRequest(Request request) {
        if (handleRequest(request)) {
            if (successor != null) {
                successor.processRequest(request);
            } else {
                throw new RuntimeException(format("Handler %s requested succession, no successor", getClass().getName()));
            }
        }
    }

    /**

     * @param request
     * @return continuation. If need to continue, return true
     */
    protected abstract boolean handleRequest (Request request);
}
