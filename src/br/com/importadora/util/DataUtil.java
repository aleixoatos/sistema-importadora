package br.com.importadora.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	public static String formataDataPadraoBrasil(Date data) {

		SimpleDateFormat converteData = new SimpleDateFormat("dd/MM/yyyy");
		String dataBrasil = converteData.format(data);
		return dataBrasil;
	}

}
