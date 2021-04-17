package io.github.pashazz.patterns.behavioural.chain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CertHandler extends Handler {
    private static final Logger LOG = LoggerFactory.getLogger(CertHandler.class);
    @Override
    protected boolean handleRequest(Request req) {
        if (req instanceof  CertRequest) {
            CertRequest request = (CertRequest)req;
            if (request.getCert().equals("MyCert")) {
                LOG.info("Authorization passed via cert");
                return false; //No need to continue.
            }
        } else {
            LOG.info("Authorization failed via certe");
        }
        return true;
    }
}
