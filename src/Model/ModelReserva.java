package Model;

import java.time.LocalDate;

public class ModelReserva {

    private String origem;
    private String destino;
    private LocalDate ida;
    private int qtdAdulto;
    private int qtdCrianca;

    public ModelReserva(String origem, String destino, LocalDate ida, int qtdAdulto, int qtdCrianca) {
        this.origem = origem;
        this.destino = destino;
        this.ida = ida;
        this.qtdAdulto = qtdAdulto;
        this.qtdCrianca = qtdCrianca;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getIda() {
        return ida;
    }

    public int getQtdAdulto() {
        return qtdAdulto;
    }

    public int getQtdCrianca() {
        return qtdCrianca;
    }
}
