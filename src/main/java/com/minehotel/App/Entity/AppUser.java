package com.minehotel.App.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppUser {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(unique = true)
    @Email(regexp = "[a-zA-Z0-9]{2,50}@[a-zA-Z]{4,12}.[a-z]{2-8}")
    private String email;

    @Column(nullable = false)
    @Size(min = 8,max = 60)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
}
