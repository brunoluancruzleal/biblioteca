package com.loja.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, length = 200)
    private String endereco;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime dataCriacaoUser;

    @Column(nullable = false, length = 20)
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private Venda venda;

    public User() {
    }

    public User(Long id, String name, String email, Integer age, String endereco, LocalDateTime dataCriacaoUser, String telefone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.endereco = endereco;
        this.dataCriacaoUser = dataCriacaoUser;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getDataCriacaoUser() {
        return dataCriacaoUser;
    }

    public void setDataCriacaoUser(LocalDateTime dataCriacaoUser) {
        this.dataCriacaoUser = dataCriacaoUser;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getAge() {
        if (this.age == null || this.age < 0) {
            throw new IllegalArgumentException("Age must be a non-negative integer.");
        }
        return age;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public void setAge(Integer age) {
        this.age = age;

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
