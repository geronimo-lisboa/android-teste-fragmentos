package estudosfragmento.geronimo.don.estudofragmentos;

import android.support.annotation.NonNull;

import java.util.Objects;
/**
 * Uma classe de uma entidadezinha qqer.
 * */
public class Pessoa {
    private String texto;
    private Integer valor;

    public Pessoa(){

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
        return Objects.equals(texto, pessoa.texto) &&
                Objects.equals(valor, pessoa.valor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(texto, valor);
    }
}
