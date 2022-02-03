package pl.edu.pwsztar.toik2.catering.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Reprezentacja danych użytkownika wysyłanych na serwer
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBody {
    /**
     * Nazwa użytkownika
     */
    private String username;
    /**
     * Hasło użytkownika
     */
    private String password;
}
