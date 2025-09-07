package util;

public class User {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String birthDate;
    private String languageLevel;

    // Конструктор
    public User(String username, String email, String password, String confirmPassword, String birthDate, String languageLevel) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.birthDate = birthDate;
        this.languageLevel = languageLevel;
    }

    // Пустой конструктор
    public User() {}

    // Геттеры
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getLanguageLevel() {
        return languageLevel;
    }

    // Сеттеры
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setLanguageLevel(String languageLevel) {
        this.languageLevel = languageLevel;
    }
}