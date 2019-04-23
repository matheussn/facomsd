package client.commons.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private String email;
    private String name;
    private String password;

    public UserDTO(){}

    public UserDTO(String name, String email, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
