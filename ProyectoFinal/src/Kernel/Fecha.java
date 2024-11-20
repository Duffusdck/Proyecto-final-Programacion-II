package Kernel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Fecha {

	LocalDate now = LocalDate.now();

	@SuppressWarnings("deprecation")
	Locale spanishLocale = new Locale("es", "ES");
	public String fecha = now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale));

}
