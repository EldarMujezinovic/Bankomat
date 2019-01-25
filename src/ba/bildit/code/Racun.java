package ba.bildit.code;
import java.util.ArrayList;

/**
 * Klasa koja obiljezava stanja i ponasanja Racuna
 * @author Eldar
 *
 */
public class Racun {

	public static ArrayList<Racun> array = new ArrayList<>();
	private int brojRacuna;
	private String imeVlasnika;
	private double iznosRacuna;
	
	
	/**
	 *  Default no args constructor
	 */
	public Racun() {
		
	}
	/**
	 * 
	 * @param brojRacuna  - prikazuje nam broj racuna
	 * @param imeVlasnika - prikazuje ime Vlasnika ciji je racun
	 * @param iznosRacuna - prikazuje nam iznos novca na racunu
	 */
	public Racun(int brojRacuna, String imeVlasnika, double iznosRacuna) {
		if(provjeraRacuna(brojRacuna, iznosRacuna)) {
		this.brojRacuna = brojRacuna;
		this.imeVlasnika = imeVlasnika;
		this.iznosRacuna = iznosRacuna;
		array.add(this);
		System.out.println("Racun je uspjeno kreiran!");
		}else {
			System.out.println("Racun nije kreiran!");
		}
	}
	/**
	 * Metoda koja ispisuje detalje racuna
	 */
	public static void ispisRacuna(int brojRacuna) {
		for(int i = 0; i < array.size(); i++) 
			if(array.get(i).brojRacuna == brojRacuna) {
				System.out.println(array.get(i).toString());
				return;
			}
			System.out.println("Racun nije pronaden!");
			
		
		
	}
	/**
	 * 
	 */
	public String toString() {
		return "Detalji vaseg racuna su: [brojRacuna=" + brojRacuna + ", imeVlasnika=" + imeVlasnika + ", iznosRacuna=" + iznosRacuna
				+ "]";
	}
	
	/**
	 * Metoda koja provjerava da li racun prolazi sve uslove u procesu kreiranja
	 * @param brojRacuna
	 * @param iznosRacuna
	 * @return
	 */
	public boolean provjeraRacuna(int brojRacuna, double iznosRacuna) {
		if(brojRacuna < 0) {
			System.out.println("Racun se ne moze kreirati jer broj racuna mora biti pozitivan broj.");
			return false;
		}
		if(iznosRacuna < 0) {
			System.out.println("Racun se ne moze kreirati jer iznos racuna mora biti pozitivan.");
			return false;
		}
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i).brojRacuna == brojRacuna){
				System.out.println("Racun se ne moze kreirati jer broj racuna vec postoji!");
				return false;
			}
		}
		return true;
		
	}
	
	/**
	 * Metoda koja provjerava da li se transfer novca moze izvrsiti
	 * @param sourceAcc
	 * @param targetAcc
	 * @param iznos
	 * @return
	 */
	public static boolean provjeraTransferaNovca(int sourceAcc, int targetAcc, double iznos) {
		
		boolean sourceExist = false;
		boolean targetExist = false;
		boolean iznosEnough = false;
		
		
		for(int i = 0; i < array.size(); i++) {
			
			  	if(array.get(i).brojRacuna == sourceAcc) {
				sourceExist = true;
			
				if(array.get(i).iznosRacuna >= iznos) 
					iznosEnough = true;
			}
			if(array.get(i).brojRacuna == targetAcc) 
				targetExist = true;
			
		}
			if (!sourceExist){
				System.out.println("Broj racuna za slanje ne postoji");
			}
			if (!targetExist) {
				System.out.println("Broj racuna za primanje ne postoji");
			}
			if (!iznosEnough) {
				System.out.println("Nemate dovoljno novca za transfer");
			}
			
			if (!sourceExist || !targetExist || !iznosEnough) {
			
				return false;
			}
			else{
				return true;
			}

}
	
	/**
	 * Metoda koja nakon provjere, vrsi transfer novca.
	 * @param sourceAcc
	 * @param targetAcc
	 * @param iznos
	 */
		public static void transferNovca(int sourceAcc, int targetAcc, double iznos) {
			if(provjeraTransferaNovca(sourceAcc, targetAcc, iznos)) {
				for(int i = 0; i < array.size(); i++) {
					if(array.get(i).brojRacuna == sourceAcc) {
						array.get(i).iznosRacuna -= iznos;
					}
					if(array.get(i).brojRacuna == targetAcc) {
						array.get(i).iznosRacuna += iznos;
					}
				}
					System.out.println("Transfer novca je uspjesno izvrsen!");		
			}
			 else {
				System.out.println("Transfer nije izvrsen!");
			}

		}
		public int getBrojRacuna() {
			return brojRacuna;
		}
		public void setBrojRacuna(int brojRacuna) {
			this.brojRacuna = brojRacuna;
		}
		public String getImeVlasnika() {
			return imeVlasnika;
		}
		public void setImeVlasnika(String imeVlasnika) {
			this.imeVlasnika = imeVlasnika;
		}
		public double getIznosRacuna() {
			return iznosRacuna;
		}
		public void setIznosRacuna(double iznosRacuna) {
			this.iznosRacuna = iznosRacuna;
		}
		
		
	
	
	
}
