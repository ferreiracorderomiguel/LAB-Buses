package fp.buses;

import fp.utiles.Checkers;

public record Etapa(String parada, Integer minutos) {

	public Etapa {
		Checkers.check("Los minutos deben ser mayores o iguales que cero.", minutos >= 0);
	}
}
