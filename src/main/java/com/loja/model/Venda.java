package com.loja.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Horario da venda
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataVenda;

    // Se ouver uma mudança na venda, o horario da mudança será registrado aqui
    @UpdateTimestamp
    @Column(nullable = true)
    private LocalDateTime dataMudancaVenda;

    // Valor total da venda
    @Column(nullable = true)
    private BigDecimal valorTotal;

    // relacinamento com o cliente que realizou a venda
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private User cliente;

//    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ItemVenda> itensVenda = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public LocalDateTime getDataMudancaVenda() {
        return dataMudancaVenda;
    }

    public void setDataMudancaVenda(LocalDateTime dataMudancaVenda) {
        this.dataMudancaVenda = dataMudancaVenda;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public User getCliente() {
        return cliente;
    }

    public void setCliente(User cliente) {
        this.cliente = cliente;
    }

//    public List<ItemVenda> getItensVenda() {
//        return itensVenda;
//    }
//
//    public void setItensVenda(List<ItemVenda> itensVenda) {
//        this.itensVenda = itensVenda;
//    }
}
