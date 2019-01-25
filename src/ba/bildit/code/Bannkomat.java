package ba.bildit.code;
import java.util.Scanner;
/**
 * Projekat ATM
 * @author Eldar
 *
 */
public class Bannkomat {
	static  Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		pocetnaStrana();
		
	}

	/*
	 * Metoda koja sluzi kao izbornik, nudi opcije korisniku, koje moze izabrati po zelji.
	 */
	public static void pocetnaStrana() {
		
		System.out.println("Izaberite koju opciju zelite izvrsiti: ");
		System.out.println("--------------------------------------");
		System.out.println("1. KREIRANJE RACUNA ");
		System.out.println("2. TRANSFER NOVCA ");
		System.out.println("3. ISPIS DETALJA POSTOJECIH RACUNA");
		System.out.println("--------------------------------------");
		int izbor = input.nextInt();
		while(izbor != 1 && izbor != 2 && izbor != 3) {
			System.out.println("Unesite jedan od ponudenih brojeva!");
			izbor = input.nextInt();
		}
		
		switch(izbor) {
		
		case 1:
			kreiranjeRacuna();
			break;
		case 2:
			transferNovca();
		case 3:
			ispisRacuna();
			
		}
	}
	
	/**
	 * Metoda koja kreira racun pomocu kreiranja objekta koji instancira na klasu Racun.
	 */
	public static void kreiranjeRacuna() {
		System.out.println(" KREIRANJE RACUNA ");
		
		System.out.println("-----------------------");
		
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input.nextInt();
		
		System.out.println("Unesite vase ime: ");
	    String  ime = input.next();
	  
	    System.out.println("Unesite iznos racuna: ");
	    double iznosRacuna = input.nextDouble();
	    
	    
	    Racun racun = new Racun(brojRacuna, ime, iznosRacuna);
	    
	    System.out.println("-----------------------");
		pocetnaStrana();
		
	}
	/**
	 * Metoda koja vrsi transfer novca pozivajuci metodu "transferNovca" iz klase "Racun", takoder 
	 * provjerava ispravnost unosa korisnika, sve dok se ne unesu pravilni podaci, program nece stati.
	 */
	public static void transferNovca() {
		System.out.println("  TRANSFER NOVCA   ");
		
		System.out.println("-----------------------");
		
		System.out.println("Unesite broj racuna sa kojeg saljete novac: ");
		int sourceAcc = input.nextInt();
		while(sourceAcc < 0) {
			System.out.println("Unesite ispravan broj racuna!");
			sourceAcc = input.nextInt();
		}
		System.out.println("Unesite broj racuna na koji saljete novac: ");
		int targetAcc = input.nextInt();
		while(targetAcc < 0) {
			System.out.println("Unesite ispravan broj racuna!");
			targetAcc = input.nextInt();
		}
		System.out.println("Unesite iznos koji zelite prebaciti: ");
		double iznos = input.nextDouble();
		while(iznos <= 0) {
			System.out.println("Unesite ispravan iznos!");
			iznos = input.nextInt();
		}
		
		Racun.transferNovca(sourceAcc, targetAcc, iznos);
		
		System.out.println("-----------------------");
		pocetnaStrana();
	}
	
	/**
	 * Metoda koja ispisuje detalje racuna pozivajuci metodu "ispisRacuna" iz klase "Racun",
	 * takoder provjerava unos korisnika pomocu while petlje.
	 */
	public static void ispisRacuna() {
		System.out.println("   ISPIS RACUNA   ");
		
		System.out.println("-----------------------");
		
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input.nextInt();
		while(brojRacuna < 0 ) {
			System.out.println("Unesite ispravan broj racuna!");
			brojRacuna = input.nextInt();
		}
		Racun.ispisRacuna(brojRacuna);
		
		System.out.println("-----------------------");
		pocetnaStrana();
	}

}
