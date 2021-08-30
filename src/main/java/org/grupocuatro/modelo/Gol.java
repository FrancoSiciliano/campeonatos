package org.grupocuatro.modelo;

import javax.persistence.*;

@Entity
@Table(name = "goles")
public class Gol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGol")
    private Integer idGol;
    @ManyToOne
    @Column(name = "idJugador")
    private Jugador jugador;
    @ManyToOne
    @Column(name = "idPartido")
    private Partido partido;
    private int minuto;
    @Column(name = "sentido")
    private String tipo;

    public Gol(Jugador jugador, Partido partido, int minuto, String tipo) {
        this.setIdGol(null);
        this.jugador = jugador;
        this.partido = partido;
        this.minuto = minuto;
        this.tipo = tipo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Partido getPartido() {
        return partido;
    }

    public int getMinuto() {
        return minuto;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getIdGol() {
        return idGol;
    }

    public void setIdGol(Integer idGol) {
        this.idGol = idGol;
    }

}
