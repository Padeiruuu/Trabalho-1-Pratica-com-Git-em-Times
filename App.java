import java.util.*;
public class App {
    private Empresa empresa;
    private Scanner in = new Scanner(System.in);
    public App() {
        empresa = new Empresa();
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run(){
        empresa.operacoes(in);
    }
}