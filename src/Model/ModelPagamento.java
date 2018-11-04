package Model;

public class ModelPagamento {

    private String NCard;
    private String Valid;
    private String Tit;
    private String Doc;
    private String pass;

    public ModelPagamento(String NCard, String Valid, String Tit, String Doc, String pass) {
        this.NCard = NCard;
        this.Valid = Valid;
        this.Tit = Tit;
        this.Doc = Doc;
        this.pass = pass;
    }

    public String getNCard() {
        return NCard;
    }

    public String getValid() {
        return Valid;
    }

    public String getTit() {
        return Tit;
    }

    public String getDoc() {
        return Doc;
    }

    public String getpass() { return pass; }

}
