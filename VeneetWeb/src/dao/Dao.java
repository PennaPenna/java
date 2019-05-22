package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Vene;

public class Dao { 
	private Connection con=null;
	private ResultSet rs = null;
	private PreparedStatement stmtPrep=null; 
	private String sql;
	
	private Connection yhdista(){
    	Connection con = null;    	        	
    	String JDBCAjuri = "org.mariadb.jdbc.Driver";
    	String url = "jdbc:mariadb://localhost:3306/bgg073";        	
    	try {
	         Class.forName(JDBCAjuri);
	         con = DriverManager.getConnection(url,"bgg073", "xoKUwd94n");	        
	     }catch (Exception e){	         
	        e.printStackTrace();	         
	     }
	     return con;
	}
	
	public boolean lisaaVene(Vene vene){
		boolean paluuArvo=true;
		sql="INSERT INTO Veneet SET nimi=?, merkkimalli=?, pituus=?, leveys=?, hinta=?";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setString(1, vene.getNimi());
			stmtPrep.setString(2, vene.getMerkkimalli());
			stmtPrep.setDouble(3, vene.getPituus());
			stmtPrep.setDouble(4, vene.getLeveys());
			stmtPrep.setDouble(5, vene.getHinta());
			stmtPrep.executeUpdate();
	        con.close();
		} catch (SQLException e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
	public ArrayList<Vene> listaaKaikki(){
		ArrayList<Vene> Veneet = new ArrayList<Vene>();
		sql = "SELECT * FROM Veneet";       
		try {
			con=yhdista();
			if(con!=null){ //jos yhteys onnistui
				stmtPrep = con.prepareStatement(sql);        		
        		rs = stmtPrep.executeQuery();   
				if(rs!=null){ //jos kysely onnistui
					con.close();					
					while(rs.next()){
						Vene vene = new Vene();
						vene.setNimi(rs.getString(2));
						vene.setMerkkimalli(rs.getString(3));
						vene.setPituus(rs.getDouble(4));	
						vene.setLeveys(rs.getDouble(5));
						vene.setHinta(rs.getDouble(6));
						Veneet.add(vene);
					}					
				}				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Veneet;
	}
	
	public boolean poistaVene(String nimi){
		boolean paluuArvo=true;
		sql="DELETE FROM Veneet WHERE nimi=?";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setString(1, nimi);
			stmtPrep.executeUpdate();
	        con.close();
		} catch (SQLException e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
	
	public ArrayList<Vene> listaaKaikki(String hakusana){
		ArrayList<Vene> Veneet = new ArrayList<Vene>();
		sql = "SELECT * FROM Veneet WHERE nimi LIKE ? or merkkimalli LIKE ?";       
		try {
			con=yhdista();
			if(con!=null){ //jos yhteys onnistui
				stmtPrep = con.prepareStatement(sql);  
				stmtPrep.setString(1, "%" + hakusana + "%");
				stmtPrep.setString(2, "%" + hakusana + "%");   
        		rs = stmtPrep.executeQuery();   
				if(rs!=null){ //jos kysely onnistui
					con.close();					
					while(rs.next()){
						Vene vene = new Vene();
						vene.setNimi(rs.getString(2));
						vene.setMerkkimalli(rs.getString(3));
						vene.setPituus(rs.getDouble(4));	
						vene.setLeveys(rs.getDouble(5));
						vene.setHinta(rs.getDouble(6));
						Veneet.add(vene);
					}					
				}				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Veneet;
	}

	public boolean muokkaaVene(Vene vene, String nimi) {
		boolean paluuArvo=true;
		sql="UPDATE Veneet SET nimi=?, merkkimalli=?, pituus=?, leveys=?, hinta=? WHERE nimi=?";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setString(1, vene.getNimi());
			stmtPrep.setString(2, vene.getMerkkimalli());
			stmtPrep.setDouble(3, vene.getPituus());
			stmtPrep.setDouble(4, vene.getLeveys());
			stmtPrep.setDouble(5, vene.getHinta());
			stmtPrep.setString(6, nimi);
			stmtPrep.executeUpdate();
	        con.close();
		} catch (SQLException e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
public String login(String user_id, String pwd) {
		String nimi=null;
		sql="SELECT nimi FROM login WHERE user_id=? AND pwd=?";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setString(1,user_id);
			stmtPrep.setString(2, pwd);
			rs = stmtPrep.executeQuery();
			if(rs.isBeforeFirst()) {
				rs.next();
				nimi=rs.getString("Nimi");
	        con.close();
			}
		} catch (SQLException e) {				
			e.printStackTrace();
		}				
		return nimi;
	}
		
	}