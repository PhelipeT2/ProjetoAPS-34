package Model;

import java.util.List;

public class ModelRecibo {

    private String nome, doc, data_nasc, tel, email, qtdAdulto, qtdCrianca, somaQtd, somaValor, bandeira, parc, origem, destino, ida, posicao;

    private List<Integer> listaAssentos;
    private ModelCadastro cadastro;
    private List<ModelDependentes> dependentes;
    private ModelPagamento pagamento;


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
    public ModelPagamento getPagamento() {
        return pagamento;
    }
    public void setPaagamento(ModelPagamento pagamento) {
        this.pagamento = pagamento;
    }




    public ModelRecibo(String nome, String doc, String data_nasc, String tel, String email, String qtdAdulto, String qtdCrianca,
                        String somaQtd, String somaValor, String bandeira, String parc, String origem, String destino, String ida, String posicao) {
        this.nome = nome;
        this.doc = doc;
        this.data_nasc = data_nasc;
        this.tel = tel;
        this.email = email;
        this.qtdAdulto = qtdAdulto;
        this.qtdCrianca = qtdCrianca;
        this.somaQtd = somaQtd;
        this.somaValor = somaValor;
        this.bandeira = bandeira;
        this.parc = parc;
        this.origem = origem;
        this.destino = destino;
        this.ida = ida;
        this.posicao = posicao;
    }
    public String getName() { return nome;}

    public String getDoc() {return doc;}

    public String getData_nasc() {return data_nasc;}

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getQtdAdulto() {
        return qtdAdulto;
    }

    public String getQtdCrianca() {
        return qtdCrianca;
    }

    public String getSomaQtd() { return somaQtd;}

    public String getSomaValor() {return somaValor;}

    public String getBandeira() {return bandeira;}

    public String getParc() { return parc;}

    public String getOrigem() { return origem;}

    public String getDestino() {return destino;}

    public String getIda() {return ida;}

    public String getPosicao() {return posicao;}
}
