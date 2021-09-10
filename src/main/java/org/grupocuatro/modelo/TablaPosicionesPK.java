package org.grupocuatro.modelo;


import java.io.Serializable;
import java.util.Objects;


public class TablaPosicionesPK implements Serializable {
    private Club id;
    private Campeonato campeonato;

    public TablaPosicionesPK(){}

    public TablaPosicionesPK(Club id, Campeonato campeonato){
        this.id = id;
        this.campeonato = campeonato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TablaPosicionesPK that = (TablaPosicionesPK) o;
        return id.equals(that.id) && campeonato.equals(that.campeonato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, campeonato);
    }
}
