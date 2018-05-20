package estudosfragmento.geronimo.don.estudofragmentos;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;
/**
 * Uma classe de uma entidadezinha qqer.
 * */
public class Pessoa implements Serializable{
    private Integer id;
    private String texto;
    private Integer valor;

    public Pessoa(){

    }

    public Pessoa(Integer id, String texto, Integer valor){
        setId(id);
        setTexto(texto);
        setValor(valor);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
