package com.example.monitoramento.metrics;

import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class PedidoProcessor {
    private final Timer tempoProcessamento;

    public PedidoProcessor(MeterRegistry registry) {
        this.tempoProcessamento = Timer.builder("pedido.processamento.tempo")
            .description("Tempo para processar um pedido")
            .publishPercentiles(0.5, 0.95, 0.99)
            .publishPercentileHistogram(true)
            .register(registry);
    }

    public <T> T processar(Supplier<T> supplier) {
        return tempoProcessamento.record(supplier::get);
    }
}
