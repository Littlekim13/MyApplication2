package activity;

/**
 * Created by PIYAPHORN on 17/5/2559.
 */
public class Login {

    @com.google.gson.annotations.SerializedName("id")
    private String cId;

    @com.google.gson.annotations.SerializedName("username")
    private String cUsername;

    @com.google.gson.annotations.SerializedName("email")
    private String cEmail;

    @com.google.gson.annotations.SerializedName("password")
    private String cPassword;

    public Login() {
        // empty
    }

    public Login(String username, String email, String password) {
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
    }
    public String getId() {
        return cId;
    }

    public final void setUsername(String username) {
        cUsername = username;
    }

    public String getUsername() {
        return cUsername;
    }

    public final void setEmail(String email) {
        cEmail = email;
    }

    public String getEmail() {
        return cEmail;
    }

    public final void setPassword(String password){
        cPassword = password;
    }

    public String getPassword() {
        return cPassword;
    }

}
