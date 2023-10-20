import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Administrador extends Usuario {
    
    private ArrayList<Pedido> pedidos;

    public Administrador(int identificador, String nome, String iniciais) {
        super(identificador, nome, iniciais);
    }


}
