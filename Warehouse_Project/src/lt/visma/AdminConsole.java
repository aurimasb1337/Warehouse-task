package lt.visma;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;  
public class AdminConsole { 

private Scanner reader;
public AdminConsole(Scanner reader) {
this.reader = reader;
}

public void start() throws ParseException
{ 
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
 
 
	
String line = "";  
String splitBy = ",";  
Warehouse w= new Warehouse(); // Kuriamas naujas objektas uz ciklo ribu, kad veliau butu galima kviesti funkcijas (ne while cikle).

try   
{  

BufferedReader br = new BufferedReader(new FileReader("C:\\sample.csv"));  // Failo vieta
br.readLine(); //read the first line and throw it away
while ((line = br.readLine()) != null) 
{  
	String[] input = line.split(splitBy);    // kableli naudojame atskirti reiksmes.

String name= input[0];
long code = Long.parseLong(input[1]);
int quanity = Integer.parseInt(input[2]);
String expiration_date= input[3];     
Item i = new Item (quanity, code, name, expiration_date);


w.add(i); // pridedame nauja objekta i musu Warehouse klase su jau is anksto nustatytais laukais is CSV failo.
}  
}   
catch (IOException e)   
{  
e.printStackTrace();  
}  



boolean end = false;
System.out.println("Sandelio prekiu programa\n-------------------\n");
while (true) {
    System.out.println(" \n[1] Perziureti trukstamu perkiu kiekius. \n[2] Patikrinti prekes, kuriu galiojimo laikas pasibaiges arba pasibaigs greitu metu. \n[x] Iseiti");
    System.out.print("> ");
    
    String command = this.reader.nextLine();
    
    if(command.equals("1")){
        System.out.println("Nurodykite prekiu kieki:");
        int inputQuanity = this.reader.nextInt();
        reader.nextLine(); // Kad nuskaitytu kaip eilutes pabaiga ir while ciklas nesisuktu du kartus :)
       w.checkAllProductsBelowQuanity(inputQuanity);
    
        
    }
    
    if(command.equals("2")){
    	 System.out.println("Iveskite data YY-MM-DD formatu:");
    	
         String userDate = this.reader.nextLine(); // Nuskaitome kaip string
     Date expiration_date = format.parse(userDate);
  w.checkExpirationDateOfProducts(expiration_date);
        
    }
    
    if(command.equals("x")){
     
                end = true;
                break;
            }
            
        
    }
    
  
}
}
