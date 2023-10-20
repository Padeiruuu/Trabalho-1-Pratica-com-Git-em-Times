import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Administrador extends Usuario {
    
    private ArrayList<Pedido> pedidos;

    public Administrador(int identificador, String nome, String iniciais) {
        super(identificador, nome, iniciais);
    }

    public ArrayList<Pedido> pedidosEntreDatas(String dataInicial, String dataFinal) {
        ArrayList<Pedido> pedidosEntreDatas = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
        try {
            Date inicio = dateFormat.parse(dataInicial);
            Date fim = dateFormat.parse(dataFinal);
    
            for (Pedido pedido : pedidos) {
                Date dataPedido = dateFormat.parse(pedido.getDataPedido());
    
                if (dataPedido.compareTo(inicio) >= 0 && dataPedido.compareTo(fim) <= 0) {
                    pedidosEntreDatas.add(pedido);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pedidosEntreDatas;
    }

    public ArrayList<Pedido> pedidoPorFuncionario(Funcionario funcionario) {
        ArrayList<Pedido> pedidosPorFuncionario = new ArrayList<>();
        for(Pedido pedido : pedidos) {
            if(pedido.getFuncionario() == funcionario) {
                pedidosPorFuncionario.add(pedido);
            }
        }
        return pedidosPorFuncionario;
    }

    public ArrayList<Pedido> pedidoPorDescricao(String descricao) {
        ArrayList<Pedido> pedidosPorDescricao = new ArrayList<>();
        for(Pedido pedido : pedidos) {
            ArrayList<Item> itens = (ArrayList<Item>) pedido.getItens();
            for(Item item : itens) {
                if(item.getDescricao().equals(descricao)) {
                    pedidosPorDescricao.add(pedido);
                }
            }
        }
        return pedidosPorDescricao;
    }

    
}
