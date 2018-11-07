package Model;

public class ModelPagamento {
    public String getNCard() {
        return NCard;
    }

    public void setNCard(String NCard) {
        this.NCard = NCard;
    }

    public String getBandeira() {
        return Bandeira;
    }

    public void setBandeira(String bandeira) {
        Bandeira = bandeira;
    }

    public String getValid() {
        return Valid;
    }

    public void setValid(String valid) {
        Valid = valid;
    }

    public String getTit() {
        return Tit;
    }

    public void setTit(String tit) {
        Tit = tit;
    }

    public String getDoc() {
        return Doc;
    }

    public void setDoc(String doc) {
        Doc = doc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    private String NCard;
    private String Bandeira;
    private String Valid;
    private String Tit;
    private String Doc;
    private String pass;
    private String nomeTitular;
    private String cpf;

    public ModelPagamento(String NCard, String bandeira, String valid, String tit, String doc, String pass, String nomeTitular, String cpf) {
        this.NCard = NCard;
        Bandeira = bandeira;
        Valid = valid;
        Tit = tit;
        Doc = doc;
        this.pass = pass;
        this.nomeTitular = nomeTitular;
        this.cpf = cpf;
    }





}
