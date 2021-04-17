package io.github.pashazz.patterns.behavioural.chain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlaintextHandler extends Handler {
    private static final Logger LOG = LoggerFactory.getLogger(PlaintextHandler.class);
    @Override
    protected boolean handleRequest(Request req) {
        if (req instanceof PlaintextRequest) {
            PlaintextRequest request = (PlaintextRequest)req;
            if (checkCredentials(request)) {
                LOG.info("Authorization passed via credentials");
                return false;
            } else {
                LOG.info("Authorization failed via credentials");
            }
        }
        return true;
    }

    private boolean checkCredentials(PlaintextRequest req) {
        return req.getUsername().equals("admin")
                && req.getPassword().equals("admin");
    }
}
