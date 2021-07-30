package sis.apartamentos.com.br;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DataTeste {

	public static void main(String[] args) {
		long diasDoMes = LocalDate.MAX.getDayOfMonth();
		System.out.println(diasDoMes);
    }
    
}