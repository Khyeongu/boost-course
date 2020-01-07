package todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dto.Todo;
import kr.or.connect.todo.dao.TodoDao;

/**
 * Servlet implementation class AddTodo
 */
@WebServlet("/add")
public class AddTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTodo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8"); 
		
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String s_sequence = request.getParameter("sequence");
		
		int sequence = Integer.parseInt(s_sequence);
		
		Todo todo = new Todo();
		todo.setTitle(title);
		todo.setName(name);
		todo.setSequence(sequence);
		
		TodoDao tododao = new TodoDao();
		tododao.addTodo(todo);
		
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
