package br.com.treinaweb.twclientes.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, name = "data_nascimento")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataNescimento;

    @Column(nullable = false)
    private String profissao;

    public Cliente(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((dataNescimento == null) ? 0 : dataNescimento.hashCode());
        result = prime * result + ((profissao == null) ? 0 : profissao.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", dataNescimento=" + dataNescimento + ", profissao="
                + profissao + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (dataNescimento == null) {
            if (other.dataNescimento != null)
                return false;
        } else if (!dataNescimento.equals(other.dataNescimento))
            return false;
        if (profissao == null) {
            if (other.profissao != null)
                return false;
        } else if (!profissao.equals(other.profissao))
            return false;
        return true;
    }

    public Cliente(Long id, String nome, LocalDate dataNescimento, String profissao) {
        this.id = id;
        this.nome = nome;
        this.dataNescimento = dataNescimento;
        this.profissao = profissao;
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNescimento() {
        return dataNescimento;
    }

    public void setDataNescimento(LocalDate dataNescimento) {
        this.dataNescimento = dataNescimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}
