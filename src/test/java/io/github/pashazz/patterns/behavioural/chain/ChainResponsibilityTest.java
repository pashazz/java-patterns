package io.github.pashazz.patterns.behavioural.chain;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Before;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ChainResponsibilityTest extends TestCase {

    private Handler handler;

    @Before
    public void setUp() {
        var certHandler = new CertHandler();
        var plaintextHandler = new PlaintextHandler();
        handler = certHandler;
        certHandler.setSuccessor(plaintextHandler);
    }


    public void testThatRightCredentialsPass() {
        PlaintextRequest request = new PlaintextRequest("admin", "admin");
        try {
            handler.processRequest(request);
        } catch (RuntimeException e) {
            fail("Should not throw an exception");
        }
    }

    public void testThatWrongCredentialsFail() {
        PlaintextRequest request = new PlaintextRequest("admin", "admin2");
        try {
            handler.processRequest(request);
            fail("Should throw RuntimeException");
        } catch (RuntimeException e) {
           // all good
        }
    }

    public void testThatRightCertPass() {
        try {
            CertRequest certRequest = new CertRequest("MyCert");
            handler.processRequest(certRequest);
        } catch (RuntimeException e) {
            fail("Should not throw an exception");
        }
    }

    public void testThatWrongCertFail() {
        try {
            CertRequest certRequest1 = new CertRequest("Randomcert"); // Should throw
            handler.processRequest(certRequest1);
            fail("Should throw RuntimeException");
        } catch (RuntimeException e ) {
            // all good

        }
    }
}