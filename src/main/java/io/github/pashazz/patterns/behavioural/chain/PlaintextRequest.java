package io.github.pashazz.patterns.behavioural.chain;

public class PlaintextRequest implements Request  {
    private String username;
    private String password;


    public PlaintextRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    public String getUsername() {
        return username;
    }
}
