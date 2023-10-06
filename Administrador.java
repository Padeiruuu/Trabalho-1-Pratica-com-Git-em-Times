import java.util.ArrayList;

public class Administrador extends Usuário {
    
    private ArrayList<Pedido> pedidos;

    public Administrador() {
        super(int identificador, String nome);
    }

    public ArrayList pedidosEntreDatas(int dataInicial, int dataFinal) {
        ArrayList<Pedido> pedidosEntreDatas = new ArrayList<Pedido>();
        for(Pedido pedido : pedidos) {
            if(pedido.getDataPedido() >= dataInicial && pedido.getDataPedido() <= dataFinal) {
                pedidosEntreDatas.add(pedido);
            }
        }
        return pedidosEntreDatas;
    }


}
