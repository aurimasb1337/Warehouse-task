package lt.visma;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Warehouse {
	 private List<Item> WarehouseStorage;
	 
	 public Warehouse() {
		 WarehouseStorage = new ArrayList<Item>();
			
		}
	 public void checkExpirationDateOfProducts(Date inputDate) {
		 
		 for (int i = 0; i < WarehouseStorage.size(); i++) { //Du for ciklai skirti "prasukti" List ir atlikti palyginimus tarp kiekvieno elemento. Sudetingumas O(n^2)
	            for (int j = i+1; j <WarehouseStorage.size() ; j++) {
	                if(WarehouseStorage.get(i).getCode()==WarehouseStorage.get(j).getCode()                        // Salyga: Spausdinant būtina apjungti dublikatus, jeigu prekės kodas, pavadinimas ir galiojimo data sutampa. 
	                		&& WarehouseStorage.get(i).getName().equals(WarehouseStorage.get(j).getName())
	                		&& WarehouseStorage.get(i).getExpiration_date().equals(WarehouseStorage.get(j).getExpiration_date())
	                		){
	              
	                    if (WarehouseStorage.get(i).getExpiration_date().compareTo(inputDate) < 0) { // Spausdinti tik tas reiksmes, kuriu suma yra mazesne nei nurodytas vartotojo kiekis.
	               	
	                    System.out.println("Dublikato, kurio ID: " + WarehouseStorage.get(i).getCode() +
	                    		" Galiojimo data yra: " + WarehouseStorage.get(i).getExpiration_date() + " Pavadinimas: " +WarehouseStorage.get(i).getName()  );
	               
	                    WarehouseStorage.remove(j);
		                   WarehouseStorage.remove(i);
	                
	              
	                    }
	                }
	              
	            }
	          
		 }
		 Collections.sort(WarehouseStorage, (p1, p2) -> p1.getName().compareTo(p2.getName())); 
		 for (Item i : WarehouseStorage) {
			 if (i.getExpiration_date().compareTo(inputDate) < 0) {
			 System.out.println("Produkto, kurio ID: " + i.getCode() + " Kiekis yra: " + i.getQuanity() + " Pavadinimas: " + i.getName() + " Galiojimo data: " + i.getExpiration_date() );
		 }}
	 }
		
		 
		
		 
		 
		
	 
	 
	 public void checkAllProductsBelowQuanity(int requiredQuanity) { 
		 
		
		 int sum=0; // nustatome pradine reiksme, kadangi naudosime si kintamaji sumuoti reiksmes.
		 int shortage = 0;
		 for (int i = 0; i < WarehouseStorage.size(); i++) { //Du for ciklai skirti "prasukti" List ir atlikti palyginimus tarp kiekvieno elemento. Sudetingumas O(n^2)
	            for (int j = i+1; j <WarehouseStorage.size() ; j++) {
	                if(WarehouseStorage.get(i).getCode()==WarehouseStorage.get(j).getCode()                        // Salyga: Spausdinant būtina apjungti dublikatus, jeigu prekės kodas, pavadinimas ir galiojimo data sutampa. 
	                		&& WarehouseStorage.get(i).getName().equals(WarehouseStorage.get(j).getName())
	                		&& WarehouseStorage.get(i).getExpiration_date().equals(WarehouseStorage.get(j).getExpiration_date())
	                		){
	                    sum+=WarehouseStorage.get(i).getQuanity()+WarehouseStorage.get(j).getQuanity();
	                    if(sum<requiredQuanity) { // Spausdinti tik tas reiksmes, kuriu suma yra mazesne nei nurodytas vartotojo kiekis.
	                    	shortage=requiredQuanity - sum;
	            
	                    System.out.println("Dublikato, kurio ID: " + WarehouseStorage.get(i).getCode() +
	                    		" kiekio suma yra: " + sum + " Pavadinimas: " +WarehouseStorage.get(i).getName() + " Trukstamas kiekis, nuo jusu nurodyto yra: " + shortage);
	                    sum=0;
	               
	              
	                    }
	                    WarehouseStorage.remove(j);
		                   WarehouseStorage.remove(i);
	                }
	              
	            }
	          
	        }
		
		 
		
			 Collections.sort(WarehouseStorage, (p1, p2) -> p1.getName().compareTo(p2.getName())); // Naudojant collections isrikiuojame pagal getName abeceles tvarka.
			 for(Item i : WarehouseStorage) {
				 if(i.getQuanity()<requiredQuanity) {
					 	shortage=requiredQuanity-i.getQuanity(); 
			      System.out.println("Produkto, kurio ID: " + i.getCode() + " Kiekis yra: " + i.getQuanity() + " Pavadinimas: " + i.getName() + " Galiojimo data: " + i.getExpiration_date() + " |Trukstamas kiekis, nuo jusu nurodyto yra: " + shortage);
			      //for cikle spausdiname reiksmes
	 }
	 }
	 }
	 
	 
	 public void add(Item item) {    
		 WarehouseStorage.add(item);  
	        }
	   
	    public void printAllItemList() {
	    	for(Item i : WarehouseStorage) {
	    		System.out.println(i.getName());
	    	}
	    	return;
	    }
}
