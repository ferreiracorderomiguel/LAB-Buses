package fp.buses;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ControlTrayectos {
	private List<Trayecto> trayectos;

    public ControlTrayectos(Stream<Trayecto> stream) {
        this.trayectos = stream.collect(Collectors.toList());
    }

    public List<Trayecto> getTrayectos() {
        return this.trayectos;
    }

    public Integer getNumTrayectos() {
        return this.trayectos.size();
    }
    
    // Tratamientos secuenciales
    // Ej 1
    public List<String> getParadasEmpresas(Set<Empresa> empresas, Character c) {
    	return null;
    }
    
    // Ej 2
    public SortedSet<Trayecto> getNTrayectosMasPasajeros(Integer n) {
    	return null;
    }

    // Ej 3
    public String getLineaMasPasajeros(Integer mes) {
    	return null;
    }
    
    // Ej 4
    public Map<Empresa, Trayecto> getTrayectoMasTiempoRecorridoPorEmpresa() {
    	return null;
    }
    
    // Ej 5
    public Integer getTotalUsuarios(String parada, LocalTime hora) {
    	return null;
    }
    
	@Override
	public int hashCode() {
		return Objects.hash(trayectos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ControlTrayectos other = (ControlTrayectos) obj;
		return Objects.equals(trayectos, other.trayectos);
	}

	@Override
	public String toString() {
		String trayectosStr = "";
        for (Trayecto trayecto : this.trayectos) {
            trayectosStr += trayecto.toString() + "\n";
        }
        
		return "ControlTrayectos [" + trayectosStr + "]";
	}
}