package fp.buses.test;

import fp.buses.ControlTrayectos;
import fp.buses.FactoriaTrayectos;

public class TestControlTrayectos {

	public static void main(String[] args) {
		ControlTrayectos cTrayectos = FactoriaTrayectos.leeTrayectos("data/trayectos.csv");

		imprimirComprobacionInicio(cTrayectos);
	}

	private static void imprimirComprobacionInicio(ControlTrayectos cTrayectos) {
		System.out.println("Número de registros leídos: " + cTrayectos.getNumTrayectos());

		System.out.println("\n3 primeros registros leídos: ");
		for (int i = 0; i < 3; i++) {
			System.out.println(cTrayectos.getTrayectos().get(i));		
		}
	}
}