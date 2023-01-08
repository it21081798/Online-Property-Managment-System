package House;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/")

public class HouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HouseDB HouseDB;
       
  
    public HouseServlet() {
    this.HouseDB = new HouseDB();  
    }
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/new":
				showRegHouse(request, response);
				break;
			case "/insert":
				inserthouse(request, response);
				break;
			case "/delete":
				deletehouse(request, response);
				break;
			case "/edit":
				editRegHouse(request, response);
				break;
			case "/update":
				updatehouse(request, response);
				break;
			default:
				houselist(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

		private void showRegHouse(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("RegHouse.jsp");
			dispatcher.forward(request, response);
		}
		
		private void inserthouse(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException {
			String type = request.getParameter("type");
			String address = request.getParameter("address");
			String description = request.getParameter("description");
			String price = request.getParameter("price");
			String phoneNo = request.getParameter("phoneNo");
			String email = request.getParameter("email");
			House NewHouse = new House (type,address,description,price,phoneNo,email); 
			HouseDB.inserthouse(NewHouse);
			response.sendRedirect("list");
		}
		
		private void deletehouse(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			HouseDB.deletethouse(id);
			response.sendRedirect("list");
		}
		
		private void editRegHouse(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			House existinghouse = HouseDB.selecthouse(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("RegHouse.jsp");
			request.setAttribute("House", existinghouse);
			dispatcher.forward(request, response);

		}	
		
		private void updatehouse(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			
			int id = Integer.parseInt(request.getParameter("id"));
			String type = request.getParameter("type");
			String address = request.getParameter("address");
			String description = request.getParameter("description");
			String price = request.getParameter("price");
			String phoneNo = request.getParameter("phoneNo");
			String email = request.getParameter("email");
			House house = new House (id,type,address,description,price,phoneNo,email);
			HouseDB.updatehouse(house);
			response.sendRedirect("list");
		}
		
		private void houselist(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			List<House> houselist = HouseDB.selectallhouse();
			request.setAttribute("houselist", houselist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("HouseList.jsp");
			dispatcher.forward(request, response);
		}
		

	
	}


