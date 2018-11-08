package Model;

import java.sql.Date;

public class ModelCadastro {
    private String Name, Doc, Email;
    private Date Age;
    private String Pwd;
    private int Tel;

    ModelCadastro(String Name, String Doc, String Email, Date Age, int Tel, String Pwd){
        this.Name = Name;
        this.Doc = Doc;
        this.Email = Email;
        this.Age = Age;
        this.Tel = Tel;
        this.Pwd = Pwd;
    }

    public String getName(){
        return Name;
    }
    public String getDoc(){
        return Doc;
    }
    public String getEmail(){
        return Email;
    }
    public Date getAge(){return Age;}
    public int getTel(){
        return Tel;
    }
    public String getPwd(){return Pwd;}

}
