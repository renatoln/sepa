package modelo.bd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Esta classe implementa um exemplo simples utilizando Banco de dados (MySQL)
 * maiores refer�ncias devem ser consultadas no java doc
 * é preciso importar para o seu projeto o driver jdbc para o MySQL
 * 
 * @author Renato Novais
 * Criada em: 21/09/2008
 * Última atualização: 21/09/2008 
 * */
public class BDMySql{
	
	private static BDMySql singleton = null;
	private Connection con;

	//padrao de projeto que cria uma �nica instancia da classe BDMySql
	public static BDMySql getInstance(){
		if (singleton == null)
		{
			singleton = new BDMySql();
		}		
			return singleton;
	}
	
	//construtor que conecta ao banco
	private BDMySql(){
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();

		      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sepa",
		        "root", "ifba");
		 /* O que quer dizer cada um dos par�mentros acima
			*  banco ->     "jdbc:mysql://localhost:3306/root"  //banco de nome sgwf no ip local (localhost)
			*  usuário -> "root"
			*  senha -> "root"
			*/
			
		   
		}
		catch(Exception e) {
                    e.printStackTrace();
			System.out.println("Nao foi possível realizar a conexão.");
		}
	}
	
	
	//Executar consultas no banco: SELECTs
	public ResultSet executarBuscaSQL(String sql){
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;
		 }
		 catch(Exception e) {
			System.out.println("Nao foi possível recuperar dados.");
                         e.printStackTrace();
			return null;
		 }
		
	}
	
	
	//executar atualizações no banco: INSERTs, UPDATEs, DELETEs
	protected void executarSQL(String sql){
		 try{
			 
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
			
		 }
		 catch(Exception e) {
			 e.printStackTrace();
                     System.out.println("Nao foi possível executar SQL.");
                        
		 }
	}
	protected int getRowCount(ResultSet rs){
		int rows = 0;
		try{
			rs.last();                 
			rows = rs.getRow();          
			rs.beforeFirst();
		}catch(Exception e){
                     e.printStackTrace();
			System.out.println("Erro ao capturar a quantidade de linhas do resultset");
		}	
		return rows;
	}
	
	//fechando a conex�o
	public void fecharConexao(){
		try{
			con.close();
		 }
		 catch(Exception e) {
                      e.printStackTrace();
			System.out.println("Nao foi poss�vel fechar a conex�o.");
		 }
	   
	}
	
	public void finalize(){
	 	fecharConexao();
  }

}
 
