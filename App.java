public class App {
    private Empresa empresa;

    public App() {
        empresa = new Empresa();
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run(){
        empresa.operacoes();
    }
}