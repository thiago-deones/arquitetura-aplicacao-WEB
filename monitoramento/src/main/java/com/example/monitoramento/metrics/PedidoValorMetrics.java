package com.example.monitoramento.metrics;

import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class PedidoValorMetrics {
    private final DistributionSummary valorPedido;

    public PedidoValorMetrics(MeterRegistry registry) {
        this.valorPedido = DistributionSummary.builder("pedido.valor")
            .description("Distribuição do valor dos pedidos (BRL)")
            .baseUnit("BRL")
            .publishPercentileHistogram(true)
            .register(registry);
    }

    public void registrarValor(double valorBruto) {
        valorPedido.record(valorBruto);
    }
}
