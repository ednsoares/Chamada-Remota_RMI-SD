import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class HelloServer implements Hello {
    public HelloServer() {}  

    public static void main(String[] args) {
        try {
            HelloServer server = new HelloServer();
            
            Hello stub = (Hello) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Servidor", stub);

            System.out.println("Servidor inicializado com sucesso.");
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    public long calcularDiferencaAnos(String data1, String data2) throws RemoteException {
        System.out.println("Executando o método calcularDiferencaAnos no servidor");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate date1 = LocalDate.parse(data1, formatter);
        LocalDate date2 = LocalDate.parse(data2, formatter);

        return ChronoUnit.YEARS.between(date1, date2);
    }
}