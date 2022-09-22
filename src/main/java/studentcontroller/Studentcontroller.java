package studentcontroller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.studentdao;
import model.modelstudentreg;

/**
 * Servlet implementation class Studentcontroller
 */
@WebServlet("/Studentcontroller")
public class Studentcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Studentcontroller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("Register")){
			modelstudentreg s = new modelstudentreg();
		    s.setfname(request.getParameter("fname"));
		    s.setlname(request.getParameter("lname"));
		    s.setemail(request.getParameter("email"));
		    s.setphone(Long.parseLong(request.getParameter("phone")));
		    s.setgender(request.getParameter("gender"));
		    s.setpassword(request.getParameter("password"));
		    studentdao.insertstudent(s);
		    request.setAttribute("msg", "data inserted succesfully");
		    request.getRequestDispatcher("studentlog.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("LOGIN")) {
			modelstudentreg s = new modelstudentreg();
			s.setemail(request.getParameter("email"));
			s.setpassword(request.getParameter("password"));
			modelstudentreg s1 = studentdao.loginstudent(s);
			System.out.println(s1);
			if(s1==null) {
				request.setAttribute("validate", "email or password incorrect");
				request.getRequestDispatcher("studentlog.jsp").forward(request, response);
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("data", s1);
				request.getRequestDispatcher("studentindex.jsp").forward(request, response);
			}
			
			
		}
		else if(action.equalsIgnoreCase("update"))
		{
			modelstudentreg s = new modelstudentreg();
			s.setfname(request.getParameter("fname"));
			s.setlname(request.getParameter("lname"));
			s.setemail(request.getParameter("email"));
			s.setphone(Long.parseLong(request.getParameter("phone")));
			s.setgender(request.getParameter("gender"));
			s.setId(Integer.parseInt(request.getParameter("id")));
			
			studentdao.updateseller(s);
			 HttpSession session = request.getSession();
		 		session.setAttribute("data", s);
		 		request.getRequestDispatcher("studentprofile.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("delete"))
		{
			modelstudentreg s = new modelstudentreg();
			s.setfname(request.getParameter("fname"));
			s.setlname(request.getParameter("lname"));
			s.setemail(request.getParameter("email"));
			s.setphone(Long.parseLong(request.getParameter("phone")));
			s.setgender(request.getParameter("gender"));
		
			
			studentdao.deleteseller(s);
			 HttpSession session = request.getSession();
		 		session.setAttribute("data ", s);
		 		request.getRequestDispatcher("studentprofile.jsp").forward(request, response);
		}
		
	}

}
