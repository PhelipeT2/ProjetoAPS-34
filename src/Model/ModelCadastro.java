package Model;

import java.time.LocalDate;

public class ModelCadastro {

    private String Name, Doc, Email;
    private LocalDate Age;
    private String Pwd;
    private int Tel;


    public ModelCadastro(String Name, String Doc, String Email, LocalDate Age, int Tel, String Pwd){
        this.Name = Name;
        this.Doc = Doc;
        this.Email = Email;
        this.Age = Age;
        this.Tel = Tel;
        this.Pwd = Pwd;
    }

    public ModelCadastro() {
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
    public LocalDate getAge(){return Age;}
    public int getTel(){
        return Tel;
    }
    public String getPwd(){return Pwd;}
    public void setName(String name) {
        Name = name;
    }

    public void setDoc(String doc) {
        Doc = doc;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setAge(LocalDate age) {
        Age = age;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public void setTel(int tel) {
        Tel = tel;
    }

}
