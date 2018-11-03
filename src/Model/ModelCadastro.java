package Model;

import java.time.LocalDate;

public class ModelCadastro {
    private String Name, SName, Doc, Addr, City, Stt, Email, KidName, KidSName, KidDoc, Age, KidAge;
    private int Numb, Zip, Tel;

    public void ModelCadastro(String Name, String SName, String Doc, String Addr, String City, String Stt, String Email,
                              String KidName, String KidSName, String KidDoc, String Age, String KidAge, int Numb,
                              int Zip, int Tel){
        this.Name = Name;
        this.SName = SName;
        this.Doc = Doc;
        this.Addr = Addr;
        this.City = City;
        this.Stt = Stt;
        this.Email = Email;
        this.KidName = KidName;
        this.KidSName = KidSName;
        this.KidDoc = KidDoc;
        this.Age = Age;
        this.KidAge = KidAge;
        this.Numb = Numb;
        this.Zip = Zip;
        this.Tel = Tel;
    }

    public String getName(){
        return Name;
    }
    public String getSName(){
        return SName;
    }
    public String getDoc(){
        return Doc;
    }
    public String getAdd(){
        return Addr;
    }
    public String getCity(){
        return City;
    }
    public String getStt(){
        return Stt;
    }
    public String getEmail(){
        return Email;
    }
    public String getKidName(){
        return KidName;
    }
    public String getKidSName(){
        return KidSName;
    }
    public String getKidDoc(){
        return KidDoc;
    }
    public String getAge(){return Age;}
    public String getKidAge(){
        return KidAge;
    }
    public int getZip(){
        return Zip;
    }
    public int getNumb(){
        return Numb;
    }
    public int getTel(){
        return Tel;
    }
}
