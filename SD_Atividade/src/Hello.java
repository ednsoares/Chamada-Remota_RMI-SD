import java.rmi.*;

public interface Hello extends Remote {
    long calcularDiferencaAnos(String data1, String data2) throws RemoteException;
}