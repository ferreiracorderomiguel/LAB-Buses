# Fundamentos de Programación
# Curso 22-23. Segundo parcial. Sesión 2: Buses

**Autor:**  José C. Riquelme 
**Revisores:** Toñi Reina, Alfonso Bengoa, Mariano González.
**Última modificación:** 30/05/2023.


Tenemos un conjunto de datos del centro de control de las líneas de autobuses interurbanos del estado de Nueva York. Para cada trayecto se tiene la siguiente información:

- **Fecha y hora**: fecha y hora de inicio de la ruta, de tipo fecha-hora
- **Nombre**: nombre de la línea, de tipo cadena.
- **Empresa**: empresa propietaria del autobús, cadena que puede tomar los valores: TUSA, TNYC, USABUS y, NYBUS.
- **Usuarios**: número total de usuarios del ese trayecto, de tipo entero. 
- **Parada inicial**: Parada de inicio del trayecto, de tipo cadena.
- **Recorrido**: lista con las paradas y tiempos estimados de llegada a cada unao de ellosellas. Cada elemento de la lista representa una etapa del trayecto, y contiene los minutos que se tardan en llegar a la parada y el nombre de la parada.

Por ejemplo, las dos primera líneas del fichero:

```
19/4/2023 10:30;Line1;TUSA;146;E-234;[21-A345, 42-G234, 17-H234]
21/3/2023 21:30;Line7;TNYC;231;H234;[18-G234, 24-F434, 15-D234, 16-C342]
```

indican que, el día 19 de abril de 2023, a las 10:30 horas, partió un autobús de la línea Line1, propiedad de la empresa TUSA. El trayecto tuvo 146 usuarios y se inició en la parada E-234. A los 21 minutos de la salida (a las 10:51) llegó a la parada A345, 42 minutos después (11:33) llegó a la parada G234, y 17 minutos después (11:50) finalizó en la parada H234. 

Importe el proyecto Autobuses y, siguiendo la metodología de clase, implemente en los paquetes fp.buses y, fp.buses.test los tipos que se piden a continuación.


**Ejercicio 1: Tipo tipo Etapa (0,5 ptos)**

Implemente el tipo Etapa mediante un record, de acuerdo con la siguiente información:

Propiedades:

- **Parada**: nombre de la parada de la etapa del trayecto, de tipo String, consultable.

- **Minutos**: minutos para llegar a la parada desde la parada anterior del trayecto, de tipo Integer, consultable.


Constructores: 

- C1: recibe un parámetro por cada propiedad básica del tipo, en el mismo orden en el que están definidas. **Nota**.: Observe que están en orden inverso a como vienen en el dataset, téngalo para que lo tenga en cuenta en la factoría.

Representación como cadena: una cadena con todas las propiedades básicas del tipo.

Restricciones:

- R1: Los los minutos deben ser mayores o iguales que cero.


**Ejercicio 2: Tipo Trayecto (1,5 ptos)**

Implemente el tipo Trayecto mediante una clase, de acuerdo con la siguiente descripción:

Propiedades:

- **FechaHora**: fecha y hora de inicio de la ruta, de tipo LocalDateTime,  consultable. 
- **Nombre**: nombre de la línea, de tipo String, consultable. 
- **Empresa**: empresa propietaria del autobús,  de tipo Empresa, consultable.  Puede tomar los valores: TUSA, TNYC, USABUS y, NYBUS.
- **Usuarios**: número total de usuarios del trayecto, de tipo Integer, consultable.  
- **Parada inicial**: parada de inicio del trayecto, de tipo String, consultable.  
- **Recorrido**: lista con las paradas y los tiempos estimados de llegada a cada una de ellas, de tipo List<Etapa>, consultable.
- **Número paradas**: número de paradas del trayecto (incluyendo la primera y la última), de tipo Integer, consultable. 
- **Hora llegada**: hora de llegada a la parada final, de tipo LocalTime, consultable. 
- **Paradas:** lista con los nombres de las paradas del trayecto (incluida la parada inicial, que deberá ser la primera de la lista), de tipo List<String>, consultable. 

Constructores: 

- C1: recibe un parámetro por cada propiedad básicas del tipo, en el mismo orden en el al que se describen..

Restricciones: 

- R1: Ddebe haber al menos una etapa en el recorrido.
- R2: lLa parada inicial no puede ser nula.

Representación como cadena: una cadena con todas las propiedades del tipo.

Criterio de igualdad: dos trayectos son iguales si lo son sus fechas, horas y nombres de líneas.

Criterio de ordenación: dos partidos trayectos se ordenan por fecha y hora, a, y a igualdad de fecha y, por  -hora, desempatan y luego por el nombre de la línea.

Otras operaciones:

- *LocalTime getHoraLlegadaParada(int ind):* Devuelve devuelve la hora a la que el autobús llegó a la parada cuyo índice es el dado como parámetro, teniendo en cuenta que el índice 0 corresponde a la primera etapa del recorrido. R, sin embargo recuerde que a la lista de paradas le debe haber insertado la parada inicial, por lo que es decir, la primera parada tras la parada inicial estará en la posición 1. Se eleva IllegalArgumentException si ind no es una posición válida de la lista de recorridosparadas.


**Ejercicio 3: Factoría (1 pto)**

En la clase FactoriaTrayectos, que se le da parcialmente implementada, implemente el método:

- *Trayecto parsearTrayectos(String lineaCSV)*: crea un objeto de tipo Trayecto a partir de una cadena de caracteres. La cadena de caracteres debe tener el mismo formato que las líneas del fichero CSV. Nota:.- Observe que las listas de Eetapas empiezan por el carácter “[“ y terminan por “]”. D deberáía reemplazar dichos caracteres por las cadenas vacías antes de procesarlas. 


**Ejercicio 4: Tratamientos secuenciales (7 ptos)**

El tipo ControlTrayectos tiene la siguiente descripción:

Propiedades:

- **trayectos**: lista de trayectos, de tipo List<Trayecto>, consultable.
- **num trayectos**: número de trayectos a controlar, de tipo Integer, consultable. 

Constructores: 

- C1: recibe un parámetro de tipo Stream<Trayecto>.

Representación como cadena: una cadena con todos los trayectos, separados por saltos de línea.

Criterio de igualdad: dos objetos de tipo ControlTrayectos son iguales si lo son sus trayectos.

Implemente el tipo ControlTrayectos en el paquete fp.buses y añada también los siguientes tratamientos secuenciales al tipo ControlTrayectos. Debe resolver todos los métodos **mediante streams**, salvo que se le indique expresamente que debe utilizar bucles:


1. *List<String> getParadasEmpresas(Set<Empresa> empresas, Character c)*: dado un conjunto de empresas y un carácter, devuelve una lista con las paradas que comienzan por ese carácter y que pertenecen al trayecto de alguna de las líneas de ese conjunto de empresas. *(1 pto)*
1. *SortedSet<Trayecto> getNTrayectosMasPasajeros(Integer n)*: dado un valor n de tipo Integer, devuelve un SortedSet con los n trayectos con más pasajeros. El SortedSet estará ordenado por fecha y hora de salida de menor a mayor. Tenga en cuenta que, si hay dos trayectos con la misma fecha y hora, ambos deberían incluirse en el conjunto resultado. *(1,5 ptos)*
1. *String getLineaMasPasajeros(Integer mes)*: dado un valor mes de tipo Integer, devuelve la línea con más pasajeros acumulados en ese mes  Si no se puede calcular, devuelve *null*. *(1,5 ptos)*
1. *Map<Empresa, Trayecto> getTrayectoMasTiempoRecorridoPorEmpresa()*: devuelve un Map en el que a cada empresa le hace corresponder el trayecto con mayor tiempo de recorrido. Para resolver este ejercicio de forma más simple debe definir un método auxiliar adecuado en el tipo Trayecto. *(2 ptos)*
1. *Integer getTotalUsuarios(String parada, LocalTime hora)*: dadas una parada y una hora, devuelve el total de usuarios de todos los trayectos que han pasado por la parada a partir de esa hora (incluyendo la parada inicial). Por ejemplo, para el trayecto representado en la primera línea del fichero mostrado al principio del enunciado, si buscamos la parada G234 y ponemos como parámetro las 11:30, entonces habría que tener en cuenta a los 146 usuarios del trayecto, ya que por la parada G234 el autobús pasó a las 11:33. Sin embargo, si la hora es 11:40, entonces no se sumarán los usuarios de ese trayecto. **Implemente este método con bucles**. (*1 pto)*

Escriba un test del tipo contenedor. En el test se leerán los datos del fichero CSV y se probarán todos los tratamientos secuenciales.

Los resultados esperados para el dataset proporcionado con los valores indicados en los tests son:

````
EJERCICIO 4.1===================================================================
Las paradas de las líneas operadas por las empresas [TNYC, USABUS] que comienzan por D son
[D654, D654, D654, D234, D234, D234, D654, D654, D654, D654, D654, D654, D234, D234, D234, D234, D654, D234, D654, D234, D234, D654, D234, D654, D654, D654, D654, D654]
Las paradas de las líneas operadas por las empresas [TUSA, NYBUS] que comienzan por G son
[G234, G234, G762, G234, G234, G234, G762, G234, G762, G234, G762, G762, G234, G234, G234, G762, G234, G234, G234, G762, G234, G234]

EJERCICIO 4.2===================================================================
Los 3 trayectos con más usuarios son
	Trayecto [fechaHora=2022-09-01T09:51, nombre=Line6, empresa=NYBUS, usuarios=294, paradaInicial=F565, recorrido=[Etapa[parada=B374, minutos=36], Etapa[parada=C342, minutos=23], Etapa[parada=C243, minutos=15], Etapa[parada=D234, minutos=38]]]
	Trayecto [fechaHora=2022-09-08T00:20, nombre=Line7, empresa=USABUS, usuarios=285, paradaInicial=A389, recorrido=[Etapa[parada=D234, minutos=26], Etapa[parada=B234, minutos=5], Etapa[parada=H435, minutos=8], Etapa[parada=F434, minutos=26], Etapa[parada=D654, minutos=32]]]
	Trayecto [fechaHora=2023-05-10T10:08, nombre=Line1, empresa=USABUS, usuarios=287, paradaInicial=E234, recorrido=[Etapa[parada=B374, minutos=50], Etapa[parada=G234, minutos=5], Etapa[parada=C342, minutos=17]]]

Los 5 trayectos con más usuarios son
	Trayecto [fechaHora=2022-09-01T09:51, nombre=Line6, empresa=NYBUS, usuarios=294, paradaInicial=F565, recorrido=[Etapa[parada=B374, minutos=36], Etapa[parada=C342, minutos=23], Etapa[parada=C243, minutos=15], Etapa[parada=D234, minutos=38]]]
	Trayecto [fechaHora=2022-09-08T00:20, nombre=Line7, empresa=USABUS, usuarios=285, paradaInicial=A389, recorrido=[Etapa[parada=D234, minutos=26], Etapa[parada=B234, minutos=5], Etapa[parada=H435, minutos=8], Etapa[parada=F434, minutos=26], Etapa[parada=D654, minutos=32]]]
	Trayecto [fechaHora=2023-03-25T08:52, nombre=Line1, empresa=TUSA, usuarios=284, paradaInicial=F565, recorrido=[Etapa[parada=D234, minutos=36], Etapa[parada=D234, minutos=24], Etapa[parada=E234, minutos=49]]]
	Trayecto [fechaHora=2023-05-10T10:08, nombre=Line1, empresa=USABUS, usuarios=287, paradaInicial=E234, recorrido=[Etapa[parada=B374, minutos=50], Etapa[parada=G234, minutos=5], Etapa[parada=C342, minutos=17]]]
	Trayecto [fechaHora=2023-05-12T15:40, nombre=Line7, empresa=NYBUS, usuarios=284, paradaInicial=C243, recorrido=[Etapa[parada=C243, minutos=15], Etapa[parada=H234, minutos=19], Etapa[parada=H435, minutos=31], Etapa[parada=E234, minutos=20]]]

EJERCICIO 4.3===================================================================
La línea con más usuarios en el mes 1 es Line9
La línea con más usuarios en el mes 10 es Line6

EJERCICIO 4.4===================================================================
Los trayectos con más tiempo de recorrido por empresa son: 
	NYBUS=Trayecto [fechaHora=2022-06-30T00:13, nombre=Line5, empresa=NYBUS, usuarios=182, paradaInicial=F565, recorrido=[Etapa[parada=A389, minutos=47], Etapa[parada=B374, minutos=20], Etapa[parada=B234, minutos=59], Etapa[parada=D654, minutos=26], Etapa[parada=C342, minutos=47]]]
	TUSA=Trayecto [fechaHora=2023-01-22T23:50, nombre=Line9, empresa=TUSA, usuarios=186, paradaInicial=B234, recorrido=[Etapa[parada=C243, minutos=59], Etapa[parada=G234, minutos=57], Etapa[parada=B374, minutos=15], Etapa[parada=A389, minutos=27], Etapa[parada=H234, minutos=46]]]
	USABUS=Trayecto [fechaHora=2023-02-26T18:28, nombre=Line7, empresa=USABUS, usuarios=232, paradaInicial=E234, recorrido=[Etapa[parada=C342, minutos=31], Etapa[parada=B234, minutos=52], Etapa[parada=B234, minutos=58], Etapa[parada=E234, minutos=44], Etapa[parada=F434, minutos=34]]]
	TNYC=Trayecto [fechaHora=2023-01-24T17:37, nombre=Line2, empresa=TNYC, usuarios=164, paradaInicial=C243, recorrido=[Etapa[parada=B374, minutos=41], Etapa[parada=C342, minutos=42], Etapa[parada=F434, minutos=26], Etapa[parada=A345, minutos=55], Etapa[parada=A389, minutos=59]]]

EJERCICIO 4.5===================================================================
El número total de usuarios de las lineas que incluyen la parada C243 con hora posterior a 10:00 es 3139
El número total de usuarios de las lineas que incluyen la parada H435 con hora posterior a 15:00 es 1960
