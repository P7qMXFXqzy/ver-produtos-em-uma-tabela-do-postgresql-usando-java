package postgre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conexao {
	private String url = "jdbc:postgresql://localhost:1234/gerenciadorestoque";
	private String usuario = "postgres";
	private String senha = "abcd";
	private Connection conexao = null;
	
	//conectar com o banco de dados
	public boolean conectar() {
		boolean tentativaConexao = false;
	    try {
	    	this.conexao = DriverManager.getConnection(url, usuario, senha);
	    	System.out.println("Conectado no banco de dados!");
	    	tentativaConexao = true;
	    } 
	    catch (SQLException e) {
	    	System.out.println("tentativa de conexão falhou!");
	    }
	    return tentativaConexao;
	   }
	
	//salvar produtos encontrados dentro de um List e mostrar todos os produtos utilizando um loop
    public void mostrarProdutos() {
        String sql = "SELECT * FROM produtos";
        try{
            Statement stmt = this.conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<List<String>> produtos = new ArrayList<List<String>>();
            while (rs.next()) {
            	produtos.add(Arrays.asList(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            };
            for(int i = 0; i < produtos.size(); i++) {
            	System.out.println(produtos.get(i));
            };
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}