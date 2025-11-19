package com.example.monitoramento.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class PedidoMetrics {
    private final MeterRegistry registry;

    public PedidoMetrics(MeterRegistry registry) {
        this.registry = registry;
    }

    public void pedidoCriado(String canal) {
        Counter.builder("pedido.criado.total")
            .description("Total de pedidos criados")
            .tag("canal", canal)
            .register(registry)
            .increment();
    }

    public void pedidoProcessamentoResultado(boolean sucesso) {
        Counter.builder("pedido.processamento.total")
            .description("Processamentos de pedido por resultado")
            .tag("resultado", sucesso ? "sucesso" : "falha")
            .register(registry)
            .increment();
    }
}
