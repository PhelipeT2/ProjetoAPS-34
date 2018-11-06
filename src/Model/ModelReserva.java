package Model;

import java.time.LocalDate;
import java.util.List;

public class ModelReserva {

    private String origem;
    private String destino;
    private LocalDate ida;
    private int qtdAdulto;
    private int qtdCrianca;
    private List<Integer> listaAssentos;
    private ModelCadastro cadastro;
    private List<ModelDependentes> dependentes;
    private ModelPagamento pagamento;

    public ModelPagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(ModelPagamento pagamento) {
        this.pagamento = pagamento;
    }
    public List<ModelDependentes> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<ModelDependentes> dependentes) {
        this.dependentes = dependentes;
    }
    public ModelCadastro getCadastro() {
        return cadastro;
    }
    public void setCadastro(ModelCadastro cadastro) {
        this.cadastro = cadastro;
    }
    public List<Integer> getListaAssentos() {
        return listaAssentos;
    }
    public void setListaAssentos(List<Integer> listaAssentos) {
        this.listaAssentos = listaAssentos;
    }


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
