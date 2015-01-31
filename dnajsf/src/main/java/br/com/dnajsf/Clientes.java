package br.com.dnajsf;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dnajsf.dao.DB;

/**
 * Servlet implementation class Clientes
 */
@WebServlet("/Clientes")
public class Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Clientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<h1> Conexão JDBC </h1>");
		out.println("<hr></hr>");
		DB db = new DB();
		
		try {
			Connection conn = db.getConn();
			String SQL = "select * from clientes";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(SQL);
			
			out.println("<h3> Listagem de Clientes </h3>");
			
			while (rs.next()){
				out.println("</br>");
				out.println("</hr>");
				out.println("Codigo : " + rs.getInt("id"));
				out.println("Nome   : " + rs.getString("nome"));
				out.println("Email  : " + rs.getString("email"));
				out.println("</hr>");
			}
			
		} catch (ClassNotFoundException e) {
			out.println("Erro Driver" + e.getMessage());
		} catch (SQLException e) {
			out.println("Erro SQL" + e.getMessage());
		}		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
