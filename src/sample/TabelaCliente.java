package sample;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class TabelaCliente {

    public SimpleLongProperty clienteCpf = new SimpleLongProperty();
    public SimpleStringProperty clienteNome = new SimpleStringProperty();
    public SimpleLongProperty clienteTelefone = new SimpleLongProperty();

    public long getClinteCpf() {
        return clienteCpf.get();
    }

    public String getClienteNome() {
        return clienteNome.get();
    }

    public long getClienteTelefone() {
        return clienteTelefone.get();
    }
}
