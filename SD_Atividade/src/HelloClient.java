import java.rmi.registry.*;
import java.util.Scanner;

public class HelloClient {
    public static void main(String[] args) {
        Scanner scanner = null; 
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");

            Hello stub = (Hello) registry.lookup("Servidor");

            scanner = new Scanner(System.in);
            
            System.out.print("Digite a primeira data (dd/MM/yyyy): ");
            String data1 = scanner.nextLine();
            
            System.out.print("Digite a segunda data (dd/MM/yyyy): ");
            String data2 = scanner.nextLine();
            
            System.out.println("Invocando o método remoto para calcular a diferença entre as datas");
            long diferencaAnos = stub.calcularDiferencaAnos(data1, data2);
            System.out.println("A diferença entre as datas é de: " + diferencaAnos + " anos"); 
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}