package trabalho.poo;

import java.time.LocalTime;

public class Sessao {
    private String codigoId;
    private Filme filme;
    private LocalTime horaInicio;
    private int capacidade;
    private int qtdIngressos;
    private double valorArrecadado;

    public Sessao(String codigoId, Filme filme, LocalTime horaInicio, int capacidade) {
        this.codigoId = codigoId;
        this.filme = filme;
        this.horaInicio = horaInicio;
        this.capacidade = capacidade;

        if (capacidade <= 0) {
            this.capacidade = 50;
        }
    }

    public Sessao(String codigoId, Filme filme, LocalTime horaInicio) {
        this.codigoId = codigoId;
        this.filme = filme;
        this.horaInicio = horaInicio;
        this.capacidade = 50;
    }

}
