package com.yedam.dev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetEmpListServlet
 */
@WebServlet("/GetEmpListServlet")
public class GetEmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmpListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath()).append(" Leejw");
		EmpDAO dao = new EmpDAO();
		List<Employee> empList = dao.getEmpList();
//		[{"id":1,"first_name":"Charil","last_name":"Falkingham","email":"cfalkingham0@sogou.com","gender":"Female","ip_address":"145.72.83.124"},
//		 {"id":2,"first_name":"Forbes","last_name":"Bugge","email":"fbugge1@bizjournals.com","gender":"Male","ip_address":"107.229.98.215"},
//		 {"id":3,"first_name":"Dion","last_name":"Curcher","email":"dcurcher2@prnewswire.com","gender":"Male","ip_address":"162.6.177.163"},
//		 {"id":4,"first_name":"Skipton","last_name":"Heazel","email":"sheazel3@squarespace.com","gender":"Male","ip_address":"136.190.131.199"},
//		 {"id":5,"first_name":"Evie","last_name":"Shyre","email":"eshyre4@tripod.com","gender":"Female","ip_address":"75.14.170.229"},
//		 {"id":6,"first_name":"Sigismondo","last_name":"Fruchter","email":"sfruchter5@behance.net","gender":"Male","ip_address":"8.169.19.142"},
//		 {"id":7,"first_name":"Cullan","last_name":"Febre","email":"cfebre6@nature.com","gender":"Male","ip_address":"76.48.180.36"},
//		 {"id":8,"first_name":"Sybila","last_name":"Pucknell","email":"spucknell7@a8.net","gender":"Female","ip_address":"106.3.49.76"},
//		 {"id":9,"first_name":"Jerrine","last_name":"Pindar","email":"jpindar8@addtoany.com","gender":"Female","ip_address":"1.225.79.159"},
//		 {"id":10,"first_name":"Tomaso","last_name":"Carnew","email":"tcarnew9@addtoany.com","gender":"Male","ip_address":"200.173.183.168"}]
		
		String empJson = "[";
		int rCnt = 0;
		int totalCnt  = empList.size();
		for(Employee e : empList) {
			empJson += "{\"empId\":" + e.getEmployeeId()
					+ ",\"firstName\":\"" + e.getFirstName()
					+ "\",\"lastName\":\"" + e.getLastName()
					+ "\",\"email\":\"" + e.getEmail()
					+ "\",\"PhoneNumber\":\"" + e.getPhoneNumber()
					+ "\"}";
			
			if(++rCnt != totalCnt) {//다르면 계속 ,를 더해주고 같은 시점이면 마지막 자료라서 ,를 더하지 않는다.
				empJson += ",";				
			}			
		}
		
		empJson += "]";
		
		PrintWriter out = response.getWriter();
		out.print(empJson);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
