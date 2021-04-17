package io.github.pashazz.patterns.behavioural.chain;

public class CertRequest implements  Request{
    private String cert;


    public CertRequest(String cert) {
        this.cert = cert;
    }

    public String getCert() {
        return cert;
    }
}
