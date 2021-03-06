package tests;

/**
 * @author Lo�c Feuga and Arnaud Garnier
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import model.GrandEntier;

public class TestGrandEntier {

	public static void main(String[] args) {

		System.out.println("\n-TEST de la class GrandEntier");
		System.out.println("--Partie constructeurs");
		System.out.println("---Constructeurs avec list");
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(2);
		GrandEntier gpetit = new GrandEntier(list);
		System.out.println("ok");
		System.out.println("\n---Constructeurs avec nombre de bit + random");
		GrandEntier ggrand = new GrandEntier(10, new Random());
		System.out.println("ok");
		System.out.println("\n\n--Partie m�thodes");
		System.out.println("---M�thode toString");
		System.out.println("J'attends " + list.get(2) + "x" + gpetit.getBASE()
				+ "^2 + " + list.get(1) + "x" + gpetit.getBASE() + "^1 + "
				+ list.get(0) + "x" + gpetit.getBASE() + "^0");
		System.out.println("\n---M�thode equals");
		System.out.println("J'attends false, j'obtiens : "
				+ gpetit.equals(ggrand));
		System.out.println("J'attends false, j'obtiens : "
				+ ggrand.equals(gpetit));
		System.out.println("J'attends true, j'obtiens : "
				+ ggrand.equals(ggrand));
		System.out.println("J'attends true, j'obtiens : "
				+ gpetit.equals(gpetit));
		System.out.println("\n---M�thode length");
		System.out.println("J'attends 3, j'obtiens : " + gpetit.length());
		System.out.println("J'attends 10, j'obtiens : " + ggrand.length());
		System.out.println("\n---M�thode compareTo");
		System.out.println("J'attends 1, j'obtiens : "
				+ ggrand.compareTo(gpetit));
		System.out.println("J'attends -1, j'obtiens : "
				+ gpetit.compareTo(ggrand));
		System.out.println("J'attends 0, j'obtiens : "
				+ ggrand.compareTo(ggrand));
		System.out.println("J'attends 0, j'obtiens : "
				+ gpetit.compareTo(gpetit));
		System.out.println("\n---M�thode shiftLeft");
		gpetit = gpetit.shitfLeft(1);
		System.out.println("J'attends " + gpetit.get(3) + "x"
				+ gpetit.getBASE() + "^3 + " + gpetit.get(2) + "x"
				+ gpetit.getBASE() + "^2 + " + gpetit.get(1) + "x"
				+ gpetit.getBASE() + "^1 + 0x" + gpetit.getBASE() + "^0");
		System.out.println("J'obtiens : " + gpetit);
		System.out.println("\n---M�thode add");
		ArrayList<Integer> list2 = new ArrayList<>();
		multiAdd(10000, 9, list2);
		list2.add(9);
		ArrayList<Integer> list3 = new ArrayList<>();
		multiAdd(10000, 9, list3);
		list3.add(9);

		GrandEntier gpetit2 = new GrandEntier(list2);
		GrandEntier gpetit3 = new GrandEntier(list3);

		Date dStartDate = new Date();
		GrandEntier gresult = gpetit2.add(gpetit3);
		Date dEndDate = new Date();
		long lExecTime = dEndDate.getTime() - dStartDate.getTime();
		System.out.println("Temps d'ex�cution pour add en millisecondes: "
				+ lExecTime);
		System.out.println(gpetit2);
		System.out.println("+");
		System.out.println(gpetit3);
		System.out.println("=" + gresult);
		System.out.println("\n---M�thode multiply");
		dStartDate = new Date();
		gresult = gpetit2.multiply(gpetit3);
		dEndDate = new Date();
		lExecTime = dEndDate.getTime() - dStartDate.getTime();
		System.out.println("Temps d'ex�cution pour multiply en millisecondes: "
				+ lExecTime);
		System.out.println(gpetit2);
		System.out.println("*");
		System.out.println(gpetit3);
		System.out.println("=" + gresult);
		
		// test, question 6
		try {
			GrandEntier.compareSimpleWithFast(args);
		} catch (Exception e) {
			System.err
					.println("Le programme a besoin d'en entier en param�tre pour specifier le nombre de tests dans une serie de test");
			e.printStackTrace();
		}

	}

	private static void multiAdd(int i, int n, ArrayList<Integer> list) {
		for (int j = 0; j < i; j++) {
			list.add(n);
		}
	}

	public void testNewAndDisplay() {

	}
}
