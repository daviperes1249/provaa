package org.senai.ecommerce.entities.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import javax.persistence.Table;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String login;

    @Transient
    private String senha;

    private UserRole role;

    public User(String login, String senha, UserRole role){
        this.login = login;
        this.senha = senha;
        this.role = role;
    }

    public String retrievePassword() {
        return senha;
    }

}