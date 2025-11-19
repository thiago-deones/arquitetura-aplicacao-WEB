package com.example.monitoramento.model;

public class Pedido {
    private Long id;
    private String cliente;
    private String produto;
    private Integer quantidade;
    private String canal; // opcional, pode vir do header ou do JSON

    public Pedido() {} // construtor vazio

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getProduto() { return produto; }
    public void setProduto(String produto) { this.produto = produto; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public String getCanal() { return canal; }
    public void setCanal(String canal) { this.canal = canal; }
}
