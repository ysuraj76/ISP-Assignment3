package model;

import java.util.GregorianCalendar;
import java.util.Random;

public class PlaceHolder {
	
	public String number(){

		Random n = new Random();
		int rand = n.nextInt(10)+1;

		System.out.println("In Order Number "+rand);

		return Integer.toString(rand);
	}
	
	public String status(){
		String[] status={"In Process","Dispatched", "Delivered"};
		Random rand = new Random();
		int  n = rand.nextInt(3);
		
		return  status[n];
	}
	
	public String name(){
		String[] nm={"Mark","James", "Oliver"};
		Random rand = new Random();
		int  n = rand.nextInt(3);
		
		return  nm[n];
	}
	
	public String pdName(){
		String[] nm={"T-Shirt","Shoes", "Cap","Jacket", "Watch"};
		Random rand = new Random();
		int  n = rand.nextInt(5);
		
		return  nm[n];
	}
	
	public String category(){
		String[] nm={"Home & Decor","Mens", "Womens","Child"};
		Random rand = new Random();
		int  n = rand.nextInt(4);
		
		return  nm[n];
	}
	
	public String address(){
		String[] nm={"Lincoln","Omaha", "Kanasas","Chicago", "Ames"};
		Random rand = new Random();
		int  n = rand.nextInt(5);
		
		return  nm[n];
	}
	
	public String date(){

		GregorianCalendar gc = new GregorianCalendar();

		Random rand = new Random();
		int  year = rand.nextInt(10)+2000;
		
        gc.set(gc.YEAR, year);
        int dayOfYear =rand.nextInt(gc.DAY_OF_YEAR)+1;

        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        
        String date = new String(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
        
        return date;
	
	}


}
