package ba.bildit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ba.bildit.code.Racun;

public class RacunTest {

	Racun racun;
	boolean ans = false;
	boolean val;
	double value;
	String name;
	

	@Before
	public void setUp(){
		racun = new Racun();
	}
	
	public void kreirajObjekte(){
		racun = new Racun(1, "Eldar", 100);
		racun = new Racun(2, "Radle", 50);
	}
	@Test
	public void shouldReturnFalseIfNumOfAccIsNegative(){
		val =  racun.provjeraRacuna(-3, 0);
		assertEquals(ans, val);
	}
	
	@Test 
	public void shouldReturnFalseIfAmountIsNegative(){
		val = racun.provjeraRacuna(1, -24.5);
		assertEquals(ans, val);
	}
	
	@Test
	public void shouldReturnFalseIfSourceAccDoesNotExist(){
		val = racun.provjeraTransferaNovca(7, 2, 50);
		assertEquals(ans, val);
	}
	
	@Test
	public void shouldReturnFalseIfTargetAccDoesNotExist(){
		val = racun.provjeraTransferaNovca(1, 3, 50);
		assertEquals(ans, val);
	}
	
	@Test
	public void shouldReturnTrueIfEverythingIsOk(){
		ans = true;
		kreirajObjekte();
		val = racun.provjeraTransferaNovca(1, 2, 30);
		assertEquals(ans, val);
	}
	
	@Test
	public void shouldReturnFalseIfThereIsNotEnoughAmountOnAcc(){
		val = racun.provjeraTransferaNovca(1, 2, 250);
		assertEquals(ans, val);
	}
	
	@Test
	public void shouldReturnBrojRacuna(){
		value = racun.getBrojRacuna();
		assertEquals(racun.getBrojRacuna(), value, 4);
	}
	
	@Test
	public void shouldReturnIznosRacuna(){
		value = racun.getIznosRacuna();
		assertEquals(racun.getIznosRacuna(), value, 4);
	}
	
	@Test
	public void shouldReturnUserName(){
		name = racun.getImeVlasnika();
		assertEquals(racun.getImeVlasnika(), name);
	}
	
	@Test
	public void shoulSetNumberOfAcc(){
		racun.setBrojRacuna(10);
		assertEquals(racun.getBrojRacuna(), 10);
	}
	
	@Test 
	public void shouldSetAmountOnAcc(){
		racun.setIznosRacuna(50);
		assertEquals(racun.getIznosRacuna(), 50, 0.001);
	}
	
	@Test
	public void shouldSetNameOfAcc(){
		racun.setImeVlasnika("Role");
		assertEquals(racun.getImeVlasnika(), "Role");
	}
	
	@Test 
	public  void shouldCangeAmountOfSourceAccAfterTransfer(){
		racun = new Racun(3,"Konj", 150);
		Racun racun2 = new Racun(4, "Magarac", 100);
		racun.transferNovca(3, 4, 30);
		value = racun.getIznosRacuna();
		assertEquals(120, value, 4);
	}
	
	@Test
	public void shouldCangeAmountOfTargetAccAfterTransfer(){
		racun = new Racun(5,"Konj", 150);
		Racun racun2 = new Racun(6, "Magarac", 100);
		racun.transferNovca(6, 5, 30);
		value = racun2.getIznosRacuna();
		assertEquals(70, value, 4);
	}
	
	
	}
	
	
	
	
	


