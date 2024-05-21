package fp.buses;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class Trayecto implements Comparable<Trayecto> {
	// Atributos
	private LocalDateTime fechaHora;
	private String nombre;
	private Empresa empresa;
	private Integer usuarios;
	private String paradaInicial;
	private List<Etapa> recorrido;
	
	// Constructores
	public Trayecto(LocalDateTime fechaHora, String nombre, Empresa empresa, Integer usuarios, String paradaInicial,
			List<Etapa> recorrido) {
		Checkers.check("Debe haber al menos una etapa en el recorrido", recorrido.size() >= 1);
		Checkers.check("La parada inicial no puede ser nula.", paradaInicial != null && !paradaInicial.equals(""));
		this.fechaHora = fechaHora;
		this.nombre = nombre;
		this.empresa = empresa;
		this.usuarios = usuarios;
		this.paradaInicial = paradaInicial;
		this.recorrido = recorrido;
	}
	
	// Métodos
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public String getNombre() {
		return nombre;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public Integer getUsuarios() {
		return usuarios;
	}

	public String getParadaInicial() {
		return paradaInicial;
	}

	public List<Etapa> getRecorrido() {
		return recorrido;
	}
	
	public Integer getNumeroParadas() {
		return recorrido.size();
	}
	
	public LocalTime getHoraLlegada() {
		Integer minTotales = 0;
		
		for (Etapa e: recorrido) {
			minTotales += e.minutos();
		}
		
		return getFechaHora().plusMinutes(minTotales).toLocalTime();
	}
	
	public List<String> getParadas() {
		List<String> res = new ArrayList<String>();
		
		res.add(paradaInicial);
		
		for (Etapa e: recorrido) {
			res.add(e.parada());
		}
		
		return res;
	}
	
	public LocalTime getHoraLlegadaParada(int ind) {
		ind = ind - 1;
		if (ind < 0 || ind >= recorrido.size()) {
	        throw new IllegalArgumentException("Indice fuera de rango");
	    }
		
		if (ind == 0) {
	        return getFechaHora().toLocalTime();
	    }
		
		int minTotales = 0;
		
		for (int i = 0; i < ind; i++) {
			minTotales += recorrido.get(i).minutos();
		}
		
		return getFechaHora().plusMinutes(minTotales).toLocalTime();
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaHora, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trayecto other = (Trayecto) obj;
		return Objects.equals(fechaHora, other.fechaHora) && Objects.equals(nombre, other.nombre);
	}
	
	public int compareTo(Trayecto t) {
		int res = this.getFechaHora().toLocalDate().compareTo(t.getFechaHora().toLocalDate());
		
		if (res == 0) {
			res = this.getFechaHora().toLocalTime().compareTo(t.getFechaHora().toLocalTime());
		}
		
		if (res == 0) {
			res = this.getNombre().compareTo(t.getNombre());
		}
		
		return res;
	}

	@Override
	public String toString() {
		return "Trayecto [fechaHora=" + fechaHora + ", nombre=" + nombre + ", empresa=" + empresa + ", usuarios="
				+ usuarios + ", paradaInicial=" + paradaInicial + ", recorrido=" + recorrido + "]";
	}
}