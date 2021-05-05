package Tasks.Task3;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;

public class main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            int number_eopies;
            int number_containers;
            ArrayList<Eopie> Eopies = new ArrayList<>();
            ArrayList<Container> Containers = new ArrayList<>();
            do{
                number_eopies=scan_eopies();
                number_containers=scan_containers();
            }while(number_containers<number_eopies);
            insert_Eopie(number_eopies, Eopies);
            insert_Container(number_containers, Containers);
            print_eopies(Eopies);
            print_containers(Containers);

        }catch(InputMismatchException e){
            System.out.println("Write numbers please");
        }
    }
    public static int scan_eopies(){
        System.out.println("Welcome to the Anti-Empire water delivery");
        System.out.println("How many Eopies do you want to use?");
        int number_eopies = sc.nextInt();
        return number_eopies;
    }
    public static int scan_containers(){
        System.out.println("How many Containers do you want to use?");
        int number_containers = sc.nextInt();
        return number_containers;
    }
    public static void insert_Eopie(int number_eopies, ArrayList<Eopie> Eopies){
        for(int i=0;i<number_eopies;i++){
            Eopie eopie = new Eopie(i,Math.random()*50+1);
            Eopies.add(eopie);
        }
    }
    public static void insert_Container(int number_containers, ArrayList<Container> Containers){
        for(int i=0;i<number_containers;i++){
            Container container = new Container(i,Math.random()*50+1);
            Containers.add(container);
        }
    }
    public static void print_eopies(ArrayList<Eopie>eopies){
        System.out.println("THIS IS THE LIST OF TOTAL EOPIES");
        for(int i=0; i<eopies.size();i++){
            System.out.println(eopies.get(i).toString());
        }
    }
    public static void print_containers(ArrayList<Container>containers){
        System.out.println("THIS IS THE LIST OF TOTAL CONTAINERS");
        for(int i=0; i<containers.size();i++){
            System.out.println(containers.get(i).toString());
        }
    }
}

