package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class User {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String birthDate;
    private String languageLevel;
    private String baseUrl;

    // Конструктор
    public User(String username, String email, String baseUrl, String password, String confirmPassword, String birthDate, String languageLevel) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.birthDate = birthDate;
        this.languageLevel = languageLevel;
    }

    // Конструктор с параметрами
    public User(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    // Пустой конструктор
    // Альтернативный способ загрузки настроек
    public static User loadFromConfig() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));
        return new User(props.getProperty("baseUrl"));
    }


    // Геттеры

    public String getBaseUrl() {
        return System.getProperty("host", "baseUrl");

    }

    public String getUsername() {
        return username;
    }

    // Сеттеры
    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getLanguageLevel() {
        return languageLevel;
    }

    public void setLanguageLevel(String languageLevel) {
        this.languageLevel = languageLevel;
    }
}