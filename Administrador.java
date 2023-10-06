import java.util.ArrayList;

public class Administrador extends Usuário {
    
    private ArrayList<Pedido> pedidos;

    public Administrador(int identificador, int nome) {
        super(identificador, nome);
    }

    public ArrayList<Pedido> pedidosEntreDatas(int dataInicial, int dataFinal) {
        ArrayList<Pedido> pedidosEntreDatas = new ArrayList<Pedido>();
        for(Pedido pedido : pedidos) {
            if(pedido.getDataPedido() >= dataInicial && pedido.getDataPedido() <= dataFinal) {
                pedidosEntreDatas.add(pedido);
            }
        }
        return pedidosEntreDatas;
    }

    public ArrayList<Pedido> pedidoPorFuncionario(Funcionário funcionário) {
        ArrayList<Pedido> pedidosPorFuncionario = new ArrayList<Pedido>();
        for(Pedido pedido : pedidos) {
            if(pedido.getFuncionario() == funcionário) {
                pedidosPorFuncionario.add(pedido);
            }
        }
        return pedidosPorFuncionario;
    }

    public ArrayList<Pedido> pedidoPorDescricao(String descrição) {
        ArrayList<Pedido> pedidosPorDescricao = new ArrayList<Pedido>();
        for(Pedido pedido : pedidos) {
            ArrayList<Item> itens = pedido.getItens();
            for(Item item : itens) {
                if(item.getDescricao() == descrição) {
                    pedidosPorDescricao.add(pedido);
                }
            }
        }
        return pedidosPorDescricao;
    }
}
