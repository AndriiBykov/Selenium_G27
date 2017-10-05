package hw;

import java.util.Arrays;
import java.util.Scanner;

public class Frogs {
	
static boolean [] frogjump (int y, boolean l[]) {
		
		//Создаем локальный массив длиной такой же как и тот, что приходит в метод.
		boolean lamp[] = new boolean[l.length];
		
		//Копируем массив
		for (int j=0; j<lamp.length; j++) {
		lamp[j] = l[j];
		}
		
		//Прыгаем жабой под номером "y"
		for (int i=y-1; i<100; i=i+y) {
			if (lamp[i]==false) {lamp[i] = true;} else {lamp[i] = false;}
		}

		//Возвращаем массив после прыжка
		return lamp;
	}
	
	public static void main(String[] args) {
		//Инициализируем номер жабы и сканнер ввода
		int frognum = 0;
		Scanner sc = new Scanner(System.in);
		boolean [] lamp = new boolean[100];
		
		//Цикл ввода номера жабы
		do {
		System.out.println("Enter number of the frog(1-100). If you want to exit enter '101' ");

		frognum = sc.nextInt();
		
		//Копируем результат метода прыжка в наш реальный массив лампочек
		lamp = frogjump(frognum, lamp);
		
		//Выводим текущее состояние лампочек
		for (int z=0; z<100; z++) {
			System.out.print(" " + lamp[z]);}
				
		} while (frognum != 101);
		
		//Закрываем сканнер и тушим программу
		sc.close();
		System.exit(0);
		
		} 
		

}
