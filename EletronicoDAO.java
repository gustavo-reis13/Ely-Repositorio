package org.libertas;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class EletronicoDAO {
	public void inserir (EletronicoDTO elet) {
		Conexao con = new Conexao();
		
		try {
			String sql = "INSERT INTO eletronico (nome, cor, qtd, preco, categoria) VALUES (?, ?, ?, ?,?)";
			PreparedStatement prep = con.getConnection().prepareStatement(sql);
			prep.setString(1, elet.getNome());
			prep.setString(2, elet.getCor());
			prep.setInt(3, elet.getQtd());
			prep.setInt(4, elet.getPreco());
			prep.setString(5, elet.getCategoria());
			prep.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar (EletronicoDTO elet) {
		Conexao con = new Conexao();
		
		try {
			String sql = "UPDATE eletronico SET nome = ?, cor = ?, qtd= ?, preco= ?  , categoria= ? WHERE ideletronico= ?";
			PreparedStatement prep = con.getConnection().prepareStatement(sql);
			prep.setString(1, elet.getNome());
			prep.setString(2, elet.getCor());
			prep.setInt(3, elet.getQtd());
			prep.setFloat(4, elet.getPreco());
			prep.setString(5, elet.getCategoria());
			prep.setInt(6, elet.getIdeletronico());
			prep.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir (EletronicoDTO elet) {
		Conexao con = new Conexao();
		
		try {
			String sql = "DELETE FROM eletronico WHERE ideletronico= ?";
			PreparedStatement prep = con.getConnection().prepareStatement(sql);
			prep.setInt(1, elet.getIdeletronico());
			prep.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public EletronicoDTO consultar (int id) {
		EletronicoDTO elet = new EletronicoDTO();
		Conexao con = new Conexao();
		
		try {
			String sql = "SELECT * FROM eletronico WHERE ideletronico = " + id;
			Statement sta = con.getConnection().createStatement();
			ResultSet res = sta.executeQuery(sql);
			if (res.next()) {
				elet.setIdeletronico(res.getInt("ideletronico"));
				elet.setNome(res.getString("nome"));
				elet.setCor(res.getString("cor"));
				elet.setQtd(res.getInt("qtd"));
				elet.setPreco(res.getInt("preco"));
				elet.setCor(res.getString("cor"));
				elet.setCategoria(res.getString("categoria"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconectar();
		return elet;
	}
	
	public List<EletronicoDTO> listar() {
		List<EletronicoDTO> lista = new LinkedList<EletronicoDTO>();
		Conexao con = new Conexao();
		
		try {
			String sql = "SELECT * FROM eletronico ORDER BY ideletronico";
			Statement sta = con.getConnection().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				EletronicoDTO elet = new EletronicoDTO();
				elet.setIdeletronico(res.getInt("ideletronico"));
				elet.setNome(res.getString("nome"));
				elet.setCor(res.getString("cor"));
				elet.setQtd(res.getInt("qtd"));
				elet.setPreco(res.getInt("preco"));
				elet.setCategoria(res.getString("categoria"));
				lista.add(elet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconectar();
		return lista;
	}
}