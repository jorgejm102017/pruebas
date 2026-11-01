package GestionReservas;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class GestionReservas {
	
	public static void escrituraReservas() {
		String cliente,nHabitacion,nNoches;
		int nReservas;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el numero de reservas");
		nReservas = Integer.parseInt(sc.nextLine());
		
	try(FileWriter fw = new FileWriter("reservas.txt"); 
			PrintWriter pw = new PrintWriter(fw)) {
		for(int i=0; i < nReservas; i++) {
			System.out.println("Introduzca el nombre de la reserva numero " + (i+1) + ":");
			cliente = sc.nextLine();
			System.out.println("Introduzca el numero de habitacion de la reserva numero " + (i+1) + ":");
			nHabitacion = sc.nextLine();
			System.out.println("Introduzca el numero de noches de la reserva numero " + (i+1) + ":");
			nNoches  = sc.nextLine();
			
			pw.println(cliente + ";" + nHabitacion + ";" + nNoches);
		}
		}	catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Error al leer el fichero:" + e.getMessage());
		}
		
	}
	
	public static void lecturaReservas() {
		int nLineas = 0;
		int sumaNoches = 0;
		String[] campos;
		 try(FileReader fr = new FileReader("reservas.txt"); 
	        	BufferedReader br = new BufferedReader(fr)){
	        	
			 String linea;
			 System.out.println("Las reservas son: ");
			 while((linea = br.readLine()) != null) {
				 nLineas += 1;
				 campos = linea.split(";");
				 sumaNoches += Integer.parseInt(campos[2]);
				 System.out.println(linea);
			 }
			 
			 System.out.println("El numero de registros leidos es:  " + nLineas);
			 System.out.println("El numero de noches acumuladas es: " + sumaNoches);
			 
			}	catch(FileNotFoundException e) {
				System.out.println("No se ha encontrado el fichero: " + e.getMessage());
			} catch (IOException e) {
				System.out.println("Error al leer el fichero:" + e.getMessage());
			}
			
	}
	
	public static void main(String[] args) {
		
		escrituraReservas();
		lecturaReservas();
	}
}
