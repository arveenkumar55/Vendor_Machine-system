/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendormachinesystem;


import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class VendorMachineSystem {

   ArrayList<Item> list=new ArrayList<Item>();//Creating arraylist.
   ArrayList<Item> cart=new ArrayList<Item>();//Creating arraylist.
   currency Curr= new currency();
   public void landingPage() {
    
     System.out.printf("%-10s %-35s %s%n", "*", "Welcome to X Machine","*");

   }
   
   public void addItem(String code, String name, int quantity, float price) {
       list.add(new Item(code,name,quantity,price,quantity*price));
   }
  public void add_item() {
    list.add(new Item("0001","coco cola",30,80,560));
    list.add(new Item("0002","sprite",30,90,630));
    list.add(new Item("0003","fanta",30,80,560));
    list.add(new Item("0004","Dew",30,90,630));
    list.add(new Item("0005","Pepsi",30,80,560));
  }
  public void add_currency() {
      Curr.set_currency(10,10,10, 10, 10, 10);
  }
  
  public void printCash() {
   System.out.printf("%-25s %s%n", "Cash:", "Quantity");      
   System.out.printf("%-25s %d%n", "thousand:", Curr.getThousand() );  
   System.out.printf("%-25s %d%n", "five hundred:", Curr.getFive_hundred());   
   System.out.printf("%-25s %d%n", "hundred:", Curr.getHundred());   
   System.out.printf("%-25s %d%n", "fifty:", Curr.getFifty());   
   System.out.printf("%-25s %d%n", "ten:", Curr.getTen());   
   System.out.printf("%-25s %d%n", "five:", Curr.getFive() );   

      

  }
   public void printItems() {
    landingPage();
    System.out.printf("%-25s %-20s %s%n", "ItemCode", "Name","Price");
    for(int i =0; i<list.size();i++) {
      System.out.printf("%2d. %-20s %-20s %.2f%n",  i + 1, list.get(i).getCode(), list.get(i).name,list.get(i).price);
   
   }
    System.out.printf("%-25s", "************************************************");
    System.out.println();
   }
   
   public void printRestockItems() {
    landingPage();
    int count =0;
    System.out.println("************Restock Item **************************");
    System.out.printf("%-25s %-20s %s%n", "ItemCode", "Name","Price");
    for(int i =0; i<list.size();i++) {
        if(list.get(i).getQuantity()<25) {
            count=count+1;
      System.out.printf("%2d. %-20s %-20s %.2f%n",  i + 1, list.get(i).getCode(), list.get(i).name,list.get(i).price);
         
        }
      
   }
    if(count ==0) {
        System.out.println("Currently there is no item for Restock");
    }
    System.out.printf("%-25s", "************************************************");
    System.out.println();
   }
   
      public void print_card_Items() {
         System.out.printf("%-10s %s %s%n", "*************************************", "Recipt","**********************************");
      System.out.printf("%-15s %-15s %-15s %s%n", "Item-code", "Item-Name","Quantity","Total-Price");
    for(int i =0; i<cart.size();i++) {
      System.out.printf("%-15s %-15s %-15d %.2f%n", cart.get(i).getCode(), cart.get(i).name,cart.get(i).getQuantity(),cart.get(i).getTotal());
   
   }
    System.out.printf("%-25s", "****************************************************************************");
    System.out.println();
   }
   public int take_input_int(String str) {
       Scanner reader = new Scanner(System.in);
       System.out.print(str);
       int i;
       i = reader.nextInt();
       return i;
   }
   
      public float take_input_float(String str) {
       Scanner reader = new Scanner(System.in);
       System.out.print(str);
       float i;
       i = reader.nextFloat();
       return i;
   }
   
    public String take_input_string(String str) {
       Scanner reader = new Scanner(System.in);
       System.out.print(str);
       String i;
       i = reader.nextLine();
       return i;
   }
   
   public boolean valid_item_code(String str) {
      
     for(int i=0;i<list.size();i++) {
         if(list.get(i).getCode().equals(str)) {
             return true; 
         }
     }       
       return false;
   }
   
   public void add_item_cart(String item_code,String name, int quantity,float price, float total_price ) {
      
      cart.add(new Item(item_code,name ,quantity,price, total_price));
   }
   public boolean decrease_available_quantity(String item_code, int quantity) {
     boolean flag=false;
    for (Item item : list) {
    if (item.getCode().equals(item_code)) {
        if(item.getQuantity()>=quantity) {
            item.setQuantity(item.getQuantity()-quantity);
            add_item_cart(item_code,item.getName(),quantity,item.getPrice(),(quantity*item.getPrice()));
            flag=true;
            break;
        }
        else {
            flag= false;
            break;
        }  
    }
}
    return flag;
   }
   
   
   public void updateItem(String item_code, int quantity) {
           for (Item item : list) {
    if (item.getCode().equals(item_code)) {
        if(item.getQuantity()>=quantity) {
            item.setQuantity(item.getQuantity()+quantity);
            break;
        }
        else {
            break;
        }  
    }
}
           
           System.out.println("Product quantity updated");
   }
   
    public void updatePrice(String item_code,float price) {
                  for (Item item : list) {
    if (item.getCode().equals(item_code)) {
        item.setPrice(price);
        break;
    }
} 
        
     System.out.println("Product Price Updated");   
    }
   
   public boolean printCustomerInvoice(float balance) {
       
       float total_balance = 0;
        for (Item item : cart) {
            total_balance = item.getTotal()+total_balance;
        }
        float tax_value= 15;
       float Vat= total_balance* (tax_value/100);
       total_balance=total_balance+Vat;
       if(total_balance > balance) {
           return false;
       }
       else {
           print_card_Items();
       SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
       Date date = new Date();

      System.out.printf("%-20s %-15.2f%n", "VAT@15%", Vat );
      System.out.printf("%-20s %-15.2f%n", "Total", total_balance);
      System.out.printf("%-20s %-15.2f%n", "Tendered", balance);
      System.out.printf("%-20s %-15.2f%n", "Change", balance-total_balance);
      System.out.printf("%-20s%n", "********************************************");
      System.out.printf("%-20s%n", "Date: "+formatter.format(date).toString());
      System.out.printf("%-20s%n", "********************************************");
      System.out.printf("%-20s%n", "Thank you for your Support  Please call Again");
      System.out.printf("%-20s%n", "********************************************");



       }
       
       return true;
   }
       
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     VendorMachineSystem Machinesystem = new VendorMachineSystem();
     Machinesystem.add_item();
     Machinesystem.add_currency();
     Machinesystem.printItems();
     int menu =Machinesystem.take_input_int("Enter an integer 1 for admin else for customer followed by <enter>: ");
     if(menu!=1) {
        int input =1;
        while (input!=0) {
            
     
        String item_code = Machinesystem.take_input_string("Enter item_code <enter>: ");
        boolean valid_code_flag = Machinesystem.valid_item_code(item_code);
        System.out.println(valid_code_flag);
        if(valid_code_flag) {
          int quantity = Machinesystem.take_input_int("Enter quantity <enter>: ");
          boolean available_quantity=Machinesystem.decrease_available_quantity(item_code, quantity);
          if(available_quantity) {
           // Machinesystem.add_item_cart(item_code, quantity);
          }
          else{
              System.out.println("Currently we haven't that much quantity as you require");

          }

        }
        else {
            System.out.println("You have entered wrong Item code");
        }
          input= Machinesystem.take_input_int("if you want to exit type 0 or continue other than 0 type <enter> :");
        }
        int balance = Machinesystem.take_input_int("Enter balance <enter> :");
        boolean flag = Machinesystem.printCustomerInvoice(balance);
        if(!flag) {
           System.out.println("you balance is less please enter more");
        }
      }
     else {
        String Password = Machinesystem.take_input_string("Enter Password <enter>: "); 
        if(Password.equals("admin")) {
            System.out.println("Enter 1 for add new item/stock");
            System.out.println("Enter 2 for change price");
            System.out.println("Enter 3 print out a summary of all items in stock");
            System.out.println("Enter 4 print out amount of cash in categories");
            System.out.println("Enter 5 print out only items that need restocking");
            System.out.println("Enter 6 for exit");
            int admin_menu = Machinesystem.take_input_int("Enter number : ");
            if(admin_menu==1) {
            String item_code = Machinesystem.take_input_string("Enter item_code <enter>: ");
            boolean valid_code_flag = Machinesystem.valid_item_code(item_code);
            if(valid_code_flag) {
          int quantity = Machinesystem.take_input_int("Enter quantity <enter>: ");
            Machinesystem.updateItem(item_code,quantity);
            Machinesystem.printItems();

        }
            else {
             String name =  Machinesystem.take_input_string("Enter Name <enter>: ");
             int quantity = Machinesystem.take_input_int("Enter quantity <enter>: ");
             float price =  Machinesystem.take_input_int("Enter price <enter>: ");
             Machinesystem.addItem(item_code,name,quantity,price);
             System.out.println("After added Product");
             Machinesystem.printItems();

            }
            }
            else if(admin_menu==2) {
            String item_code = Machinesystem.take_input_string("Enter item_code <enter>: ");
            boolean valid_code_flag = Machinesystem.valid_item_code(item_code);
            if(valid_code_flag) {
              float price = Machinesystem.take_input_float("Enter price <enter>: ");
              Machinesystem.updatePrice(item_code,price);
              Machinesystem.printItems();

            }
            else {
               System.out.println("You have entered wrong Item code");

            }
            }
            else if(admin_menu==3) {
              Machinesystem.printItems();

            }
            
            else if(admin_menu==4) {
                Machinesystem.printCash();
            }
            
             else if(admin_menu==5) {
                Machinesystem.printRestockItems();
            }
               else if(admin_menu==6) {
     System.out.println("*************** Program terminates****************");
            }

        }
        else {
            System.out.println("You have entered wrong Password");
        }
           
     }
     
     System.out.println("*************** Program terminates****************");

     
    }
   
}
