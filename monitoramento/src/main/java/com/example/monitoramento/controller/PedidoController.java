package com.example.monitoramento.controller;

import com.example.monitoramento.model.Pedido;
import com.example.monitoramento.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
@Tag(name = "Pedidos", description = "Endpoints para criação e monitoramento de pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @Operation(summary = "Criar um novo pedido",
               description = "Recebe os dados de um pedido em JSON e retorna o pedido criado")
    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido,
                                              @RequestHeader(value = "X-Canal", required = false) String canal) {
        // Simula salvar o pedido
        pedido.setId(System.currentTimeMillis()); // gera ID fictício
        pedido.setCanal(canal != null ? canal : "web");

        // chama o service para simular criação
        service.criarPedido(pedido.getQuantidade() != null ? 
                            BigDecimal.valueOf(pedido.getQuantidade()) : BigDecimal.ONE);

        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @Operation(summary = "Endpoint de teste",
               description = "Retorna uma mensagem simples para confirmar que a API está no ar.")
    @GetMapping
    public String healthCheck() {
        return "API de pedidos está rodando!";
    }
}
