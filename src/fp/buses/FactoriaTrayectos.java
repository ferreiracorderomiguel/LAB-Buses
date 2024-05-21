package fp.buses;

import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Paths;
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

	public static Trayecto parseaTrayecto(String lineaCSV) {
		/*
		 * 19/4/2023 10:30;Line1;TUSA;146;E-234;[21-A345, 42-G234, 17-H234]
		 * 21/3/2023 21:30;Line7;TNYC;231;H234;[18-G234, 24-F434, 15-D234, 16-C342]
		 */
		
		String[] trozos = lineaCSV.split(";");
		Checkers.check("Cadena mal troceada", trozos.length == 6);
		
		LocalDateTime fechaHora = LocalDateTime.parse(trozos[0].trim(), DateTimeFormatter.ofPattern("d/M/yyyy H:mm"));
		String nombre = trozos[1].trim();
		Empresa empresa = Empresa.valueOf(trozos[2].trim());
		Integer usuarios = Integer.parseInt(trozos[3].trim());
		String paradaInicial = trozos[4].trim();
		List<Etapa> recorrido = parseaRecorrido(trozos[5].trim());
		
		return new Trayecto(fechaHora, nombre, empresa, usuarios, paradaInicial, recorrido);
	}

	private static List<Etapa> parseaRecorrido(String trim) {
		List<Etapa> res = new ArrayList<Etapa>();
		trim = trim.replace("[", "").replace("]", "");
		String[] trozos = trim.split(",");
		
		for(String s: trozos) {
			String[] stringEtapa = s.split("-");
			String parada = stringEtapa[1].trim();
			Integer minutos = Integer.parseInt(stringEtapa[0].trim());
			res.add(new Etapa(parada, minutos));
		}
		
		return res;
	}
}
