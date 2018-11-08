package sample;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class TabelaCliente {

    public Long getClienteCpf() {
        return clienteCpf.get();
    }

    public void setClienteCpf(long clienteCpf) {
        this.clienteCpf.set(clienteCpf);
    }

    public String getClienteNome() {
        return clienteNome.get();
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome.set(clienteNome);
    }

    public Long getClienteTelefone() {
        return clienteTelefone.get();
    }

    public void setClienteTelefone(long clienteTelefone) {
        this.clienteTelefone.set(clienteTelefone);
    }

    public SimpleLongProperty clienteCpf ;
    public SimpleStringProperty clienteNome ;
    public SimpleLongProperty clienteTelefone;

    public TabelaCliente(long clienteCpf, String clienteNome, long clienteTelefone) {
        this.clienteCpf = new SimpleLongProperty(clienteCpf);
        this.clienteNome =new SimpleStringProperty(clienteNome);
        this.clienteTelefone = new SimpleLongProperty(clienteTelefone);
    }


}
