package io.github.pashazz.patterns.behavioural.chain;

public class Main {

    //see unit test at

    public static void main(String[] args) {
        // Set up the chain
        Handler handler;
        CertHandler certHandler = new CertHandler();
        PlaintextHandler plaintextHandler = new PlaintextHandler();
        handler = certHandler;
        certHandler.setSuccessor(plaintextHandler);

        try {
            CertRequest certRequest1 = new CertRequest("Randomcert"); // Should throw
            handler.processRequest(certRequest1);
            System.err.println("cert: Something is wrong");
        } catch (RuntimeException e ) {
            System.out.println("cert Authentication failed as expected");
        }

        CertRequest certRequest =  new CertRequest("MyCert");
        handler.processRequest(certRequest);

        PlaintextRequest plaintextRequest = new PlaintextRequest("admin", "admin");
        handler.processRequest(plaintextRequest);

        // Should fail now
         try {
            PlaintextRequest ptrq1 = new PlaintextRequest("lol", "lol"); // Should throw
            handler.processRequest(ptrq1);
            System.err.println("pass: Something is wrong");
        } catch (RuntimeException e ) {
            System.out.println("password Authentication failed as expected");
        }


    }
}
