package fp.buses;

import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

import fp.utiles.Checkers;




public class FactoriaTrayectos {

	
	public static ControlTrayectos leeTrayectos(String ruta) {
		ControlTrayectos res = null;
		try {
			Stream<Trayecto> sv = Files.lines(Paths.get(ruta))
										.map(FactoriaTrayectos::parseaTrayecto);
			res = new ControlTrayectos(sv);
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero " + ruta);
			e.printStackTrace();
		}
		return res;
	}

	
}
