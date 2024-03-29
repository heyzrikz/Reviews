import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDao extends ConnessioneDao {

	public boolean verificaAccesso(String username,String password) throws Exception{
		   Connection con=getConnection();
		  try{ 
			   String select="SELECT nome_utente FROM public.utente WHERE username=? AND password_utente=? ;";
			   PreparedStatement CercaUtente=con.prepareStatement(select);
		   CercaUtente.setString(1, username);
		   CercaUtente.setString(2, password);
		   ResultSet rs= CercaUtente.executeQuery();
		   if(!rs.next()==false){
			   rs.close();
			  return true;}else return false;
		  }catch(Exception e){
			   System.err.println("Errore select");
			   return false;}}
	
	public boolean verificaSeAccountProprietario(String username) throws Exception{
		Connection con=getConnection();
		String select="SELECT selected_proprietario FROM public.utente WHERE username=?";
		PreparedStatement verificaAccount=con.prepareStatement(select);
		verificaAccount.setString(1, username);
		ResultSet rs=verificaAccount.executeQuery();
		while(rs.next()){
			if(rs.getBoolean("selected_proprietario")){
			return true;}
		else return false;}
		return false;}
	
	public void inserisciUtenteDb(String nome,String cognome,String nick,String password,boolean moderatore) throws Exception{
		   Connection con=getConnection();
		   try{
		PreparedStatement UpdateUtente=con.prepareStatement("INSERT INTO public.utente( nome_utente, cognome_utente, username, password_utente,selected_proprietario) VALUES (?, ?, ?, ?, ?);");
		UpdateUtente.setString(1, nome);
		UpdateUtente.setString(2, cognome);
		UpdateUtente.setString(3, nick);
		UpdateUtente.setString(4, password);
		UpdateUtente.setBoolean(5, moderatore);
		UpdateUtente.executeUpdate();}catch(SQLException sqe){
			System.err.println("Problema");}}	
	
	public boolean verificaInserimentoDbUtente(String nick) throws Exception{
		   Connection con=getConnection();
		  try{ 
			   String select="SELECT nome_utente FROM public.utente WHERE username=? ;";
			   PreparedStatement CercaUtente=con.prepareStatement(select);
		   CercaUtente.setString(1, nick);
		   ResultSet rs= CercaUtente.executeQuery();
		   if(!rs.next()==false){
			   rs.close();
			  return false;}else return true;
		  }catch(Exception ex){
			   System.err.println("Errore Verifica Inserimento db");
			   return true;}}
	
}
