package se.lexicon.marketplaceapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTORequest {

    @NotBlank(message = "Please enter en email")
    @Email(message = "Please enter a valid email")
    private String email;
    @NotBlank(message = "enter the password")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
