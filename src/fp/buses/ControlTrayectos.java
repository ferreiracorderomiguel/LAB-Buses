package fp.buses;

import java.util.List;
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
	
}
