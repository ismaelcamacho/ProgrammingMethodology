package Tasks.Task3;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

import java.lang.Math;
import java.util.InputMismatchException;
import java.io.*;

public class main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try {
        	int menu = 0;
        	ArrayList<Eopie> Eopies = new ArrayList<>();
            ArrayList<Container> Containers = new ArrayList<>();
            Travel [] travels = null;
            int number_eopies;
            int number_containers;
            
            do {
                number_eopies = scan_eopies();
                number_containers = scan_containers();
            } while (number_containers < number_eopies);
        	
        	do {
        		
        		main_menu(menu, number_eopies, Eopies, number_containers, Containers, travels);
     		
        	} while (menu!=3);
    
            
        } catch (InputMismatchException e) {
            System.out.println("Write numbers please");
        }
    }
    
    public static void main_menu (int menu, int number_eopies, ArrayList<Eopie> Eopies, int number_containers, ArrayList <Container> Containers, Travel [] travels) throws IOException{
    	
    	System.out.println("Choose 1 for 1 Day. Choose 2 for 7 days");
		try  {
			do {
				menu = sc.nextInt();
				
			} while (menu <1 || menu >3);
			
			switch (menu) {
    		
    		case 1:
    			
    			Eopies = new ArrayList<>();
                Containers = new ArrayList<>();
    			
    			insert_Eopie(number_eopies, Eopies);
                insert_Container(number_containers, Containers);
                print_eopies(Eopies);
                print_containers(Containers);
                eopie_sort(Eopies, 0, Eopies.size() - 1);
                container_sort(Containers, 0, Containers.size() - 1);
                
                travels = greedyTravels(Eopies, Containers, Eopies.size());
                print_travels(travels);
    			
    			break;		
    			
    		case 2:
    			
    			Eopies = new ArrayList<>();
                Containers = new ArrayList<>();
                
                travels = new Travel [(number_eopies*number_containers*7)+1];
               
                
    			
    			int n_travels = 0;
    			
    			for (int n = 0; n<7;n++) {
    				Eopies.clear();
                    Containers.clear();
    				insert_Eopie(number_eopies, Eopies);
                    insert_Container(number_containers, Containers);
                    print_eopies(Eopies);
                    print_containers(Containers);
                    
                    eopie_sort(Eopies, 0, Eopies.size() - 1);
                    container_sort(Containers, 0, Containers.size() - 1);
                    
                    travels = greedyTravels_7days(Eopies, Containers, Eopies.size()*7, n_travels, travels);
                    n_travels = n_travels_7_days(travels,n_travels);
                    
                    
            
    			}
    			
    			print_travels(travels);
    			
    			break;
    		
    		}
			
		} catch (InputMismatchException e) {
			System.out.println("Error.Introduce a number");
			sc.next();
			main_menu(menu, number_eopies, Eopies, number_containers, Containers, travels);
			
		}
    }

    public static int scan_eopies() {
        System.out.println("Welcome to the Anti-Empire water delivery");
        System.out.println("How many Eopies do you want to use?");
        int number_eopies = sc.nextInt();
        return number_eopies;
    }

    public static int scan_containers() {
        System.out.println("How many Containers do you want to use?");
        int number_containers = sc.nextInt();
        return number_containers;
    }

    public static void insert_Eopie(int number_eopies, ArrayList<Eopie> Eopies) {
        for (int i = 0; i < number_eopies; i++) {
            Eopie eopie = new Eopie(i, Math.random() * 50 + 1);
            Eopies.add(eopie);
        }
    }

    public static void insert_Container(int number_containers, ArrayList<Container> Containers) {
        for (int i = 0; i < number_containers; i++) {
            Container container = new Container(i, Math.random() * 50 + 1);
            Containers.add(container);
        }
    }

    public static void print_eopies(ArrayList<Eopie> eopies) {
        System.out.println("THIS IS THE LIST OF TOTAL EOPIES");
        for (int i = 0; i < eopies.size(); i++) {
            System.out.println(eopies.get(i).toString());
        }
    }

    public static void print_containers(ArrayList<Container> containers) {
        System.out.println("THIS IS THE LIST OF TOTAL CONTAINERS");
        for (int i = 0; i < containers.size(); i++) {
            System.out.println(containers.get(i).toString());
        }
    }

    public static void container_sort(ArrayList<Container> containers, int min, int max) {
        if (min < max) {
            int position = container_partition(containers, min, max);
            container_sort(containers, min, position);
            container_sort(containers, position + 1, max);
        }
    }

    public static int container_partition(ArrayList<Container> containers, int min, int max) {
        double pivot = containers.get(min).getWater_volume();
        int i = min - 1;
        int j = max + 1;
        do {
            do {
                j = j - 1;
            } while (containers.get(j).getWater_volume() > pivot);
            do {
                i = i + 1;
            } while (containers.get(i).getWater_volume() < pivot);
            if (i < j) {
                container_replace(containers, i, j);
            }
        } while (i < j);
        return j;
    }

    public static void container_replace(ArrayList<Container> containers, int i, int j) {
        int local1 = containers.get(i).getContainer_id();
        double local2 = containers.get(i).getWater_volume();
        containers.get(i).setContainer_id(containers.get(j).getContainer_id());
        containers.get(i).setWater_volume(containers.get(j).getWater_volume());
        containers.get(j).setContainer_id(local1);
        containers.get(j).setWater_volume(local2);
    }

    public static void eopie_sort(ArrayList<Eopie> eopies, int min, int max) {
        if (min < max) {
            int position = eopie_partition(eopies, min, max);
            eopie_sort(eopies, min, position);
            eopie_sort(eopies, position + 1, max);
        }
    }

    public static int eopie_partition(ArrayList<Eopie> eopies, int min, int max) {
        double pivot = eopies.get(min).getCarry_volume();
        int i = min - 1;
        int j = max + 1;
        do {
            do {
                j = j - 1;
            } while (eopies.get(j).getCarry_volume() > pivot);
            do {
                i = i + 1;
            } while (eopies.get(i).getCarry_volume() < pivot);
            if (i < j) {
                eopie_replace(eopies, i, j);
            }
        } while (i < j);
        return j;
    }

    public static void eopie_replace(ArrayList<Eopie> eopies, int i, int j) {
        int local1 = eopies.get(i).getEopie_id();
        double local2 = eopies.get(i).getCarry_volume();
        eopies.get(i).setEopie_id(eopies.get(j).getEopie_id());
        eopies.get(i).setCarry_volume(eopies.get(j).getCarry_volume());
        eopies.get(j).setEopie_id(local1);
        eopies.get(j).setCarry_volume(local2);
    }
    
    public static Travel [] greedyTravels_7days (ArrayList<Eopie> eopies, ArrayList<Container> containers, int size, int counter, Travel [] travels) {
    	
    	int pos = 0;
         	
    	for (int i = 0; i < eopies.size(); i++) {
    		boolean delete = false;
            for (int j = 0; j < containers.size(); j++) {
                if (eopies.get(i).getCarry_volume() >= containers.get(j).getWater_volume()) {
                    travels[counter] = new Travel (eopies.get(i), containers.get(j));
                    pos = j;
                    delete = true;
                    
                }
            }
            if (delete == true) {
            	counter++;
            	containers.remove(pos);
            }
        }
    	return travels;
    }

    public static Travel [] greedyTravels (ArrayList<Eopie> eopies, ArrayList<Container> containers, int size) {
    	Travel [] travels = new Travel [size];
    	int pos = 0;
         	
    	for (int i = 0; i < eopies.size(); i++) {
    		boolean delete = false;
            for (int j = 0; j < containers.size(); j++) {
                if (eopies.get(i).getCarry_volume() >= containers.get(j).getWater_volume()) {
                    travels[i] = new Travel (eopies.get(i), containers.get(j));
                    pos = j;
                    delete = true;
                }
            }
            if (delete == true) {
            	containers.remove(pos);
            }
        }
    	return travels;
    }

    public static void print_travels(Travel [] travels) {
        int total_liters=0;
        System.out.println("THIS IS THE LIST OF TOTAL TRAVELS");
        for (int i = 0; i < travels.length; i++) {
        	if (travels[i]!=null) {
        		total_liters+=travels[i].container.getWater_volume();
                System.out.println(travels[i].toString());
        	}
        }
        System.out.println("Total of litter carried by all the Eopies is=" + total_liters);
    }
    
    public static int n_travels_7_days (Travel [] travels, int counter) {
        
        for (int i = 0; i < travels.length; i++) {
        	if (travels[i]!=null) {
                //System.out.println(travels[i].toString());
                counter++;
        	}
        }
         
        return counter;
    }
}

