package org.grupocuatro.modelo;

import java.io.Serializable;
import java.util.Objects;

public class ListaJugadoresDeshabilitadosPK implements Serializable {

    private Jugador jugador;
    private Campeonato campeonato;

    public ListaJugadoresDeshabilitadosPK() {}

    public ListaJugadoresDeshabilitadosPK(Jugador j, Campeonato campeonato) {
        this.jugador = j;
        this.campeonato = campeonato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaJugadoresDeshabilitadosPK that = (ListaJugadoresDeshabilitadosPK) o;
        return jugador.equals(that.jugador) && campeonato.equals(that.campeonato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jugador, campeonato);
    }
}
