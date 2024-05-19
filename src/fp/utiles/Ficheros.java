package fp.utiles;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ficheros {
		/**
		 * @param path
		 *            Ruta del fichero a leer.
		 * @return Una lista de String en la que cada elemento se corresponde con una de las
		 *         l�neas del fichero leido. El ordinal de la l�nea, por tanto, est�
		 *         relacionado con la posici�n de la l�nea en la lista.
		 */
		public static List<String> leeFichero(String path) {
			List<String> res = null;
			try {
				res = Files.readAllLines(Paths.get(path),StandardCharsets.UTF_8);
			} catch (IOException e) {
				e.printStackTrace();
				res = new ArrayList<String>();
			}
			return res;
		}
	}

