package Model;

import java.time.LocalDate;

public class ModelCadastro {
    private String Name, SName, Doc, Add, City, Stt, Email, KidName, KidSName, KidDoc;
    private LocalDate Age, KidAge;
    private int Numb, Zip, Tel;

    public void ModelCadastro(String Name, String SName, String Doc, String Add, String City, String Stt, String Email,
                              String KidName, String KidSName, String KidDoc, LocalDate Age, LocalDate KidAge, int Numb,
                              int Zip, int Tel){
        this.Name = Name;
        this.SName = SName;
        this.Doc = Doc;
        this.Add = Add;
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
        return Add;
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
        return SName;
    }
    public String getKidDoc(){
        return KidDoc;
    }
    public LocalDate getAge(){
        return Age;
    }
    public LocalDate getKidAge(){
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
