package trabalho.poo;

import java.time.LocalTime;

public class Sessao {
    private final String codigoId;
    private final Filme filme;
    private final LocalTime horaInicio;
    private final int capacidade;
    private static double precoIngresso = 20.00;
    private int qtdIngressos;
    private double valorArrecadado;

    public Sessao(String codigoId, Filme filme, LocalTime horaInicio, int capacidade) {
        int capacidadeFinal;

        if (capacidade > 0) {
            capacidadeFinal = capacidade;
        } else {
            capacidadeFinal = 50;
        }

        this.codigoId = codigoId;
        this.filme = filme;
        this.horaInicio = horaInicio;
        this.capacidade = capacidadeFinal;
    }

    public Sessao(String codigoId, Filme filme, LocalTime horaInicio) {
        this(codigoId, filme, horaInicio, 50);
    }

    public String getCodigoId() {
        return codigoId;
    }

    public Filme getFilme() {
        return filme;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getQtdIngressos() {
        return qtdIngressos;
    }

    public double getValorArrecadado() {
        return valorArrecadado;
    }

    public int getLugaresDisponiveis() {
        return capacidade - qtdIngressos;
    }

    public static double getPrecoIngresso() {
        return precoIngresso;
    }

    public static boolean setPrecoIngresso(double precoIngresso) {
        if (precoIngresso > 0) {
            Sessao.precoIngresso = precoIngresso;
            return true;
        }
        return false;
    }

    private static double getValorComDesconto(double percentualDesconto) {
        return precoIngresso - (precoIngresso * percentualDesconto / 100);
    }

    public int venderIngresso(int idade) {
        if (idade < 0) {
            return -1;
        }
        if (!filme.podeAssistir(idade)) {
            return -2;
        }

        if (getLugaresDisponiveis() <= 0) {
            return -3;
        }

        qtdIngressos++;
        valorArrecadado += getValorComDesconto(0);
        return 0;

    }

    public int venderIngresso(int idade, String documento) {

        if (documento == null || documento.trim().isEmpty() || idade < 0) {
            return -1;
        }

        if (!filme.podeAssistir(idade)) {
            return -2;
        }

        if (getLugaresDisponiveis() <= 0) {
            return -3;
        }

        qtdIngressos++;
        valorArrecadado += getValorComDesconto(50);
        return 0;
    }

    public LocalTime getHoraTermino() {
        return horaInicio.plusMinutes(filme.getDuracao());
    }
}
