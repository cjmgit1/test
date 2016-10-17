package j31.java.web;

import j31.java.dao.ShowDao;
import j31.java.entity.PageForum;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.r;

public class ShowServlet extends HttpServlet {

	private ShowDao dao=new ShowDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		if(method.equals("GetInfo"))
		{
			GetInfo(request,response);
		}else if(method.equals("change"))
		{
			change(request,response);
		}else if(method.equals("deleteInfo"))
		{
			deleteInfo(request,response);
		}else if(method.equals("ShowInfo"))
		{
			ShowInfo(request,response);
		}else if(method.equals("findByShow"))
		{
			findByShow(request,response);
		}else if(method.equals("ShowInfochange"))
		{
			ShowInfochange(request,response);
		}else if(method.equals("Add"))
		{
			Add(request,response);
		}else if(method.equals("AddLiuyan"))
		{
			AddLiuyan(request,response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doGet(request,response);
	}
	public void GetInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name=request.getParameter("username");
		
		PageForum p=new PageForum();
		p.setCount(dao.getCount());
		
		List<Map<String, Object>> showlist=dao.GetInfo(p);
		
		request.getSession().setAttribute("name1",name);
		request.getSession().setAttribute("showlist", showlist);
		request.getSession().setAttribute("p", p);
		
		request.getRequestDispatcher("pages/show.jsp").forward(request, response);
		
	}
	public void change(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer index=Integer.parseInt(request.getParameter("index"));
		
		PageForum p=(PageForum)request.getSession().getAttribute("p");
		
		p.setIndex(index);
		
		List<Map<String, Object>> showlist=dao.GetInfo(p);
		request.getSession().setAttribute("showlist", showlist);
		request.getSession().setAttribute("p", p);
		
		request.getRequestDispatcher("pages/show.jsp").forward(request, response);
		
		
	}
	
	public void deleteInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		dao.delre(id);
		dao.deleteInfo(id);
		
		GetInfo(request,response);
		
	}
	
	public void ShowInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		
		Integer id=(Integer)request.getSession().getAttribute("id");
		
		
		PageForum showinfop=new PageForum();
		
		showinfop.setCount(dao.getCount(id));
		
		List<Map<String, Object>> showinfolist=dao.getShowInfo(id, showinfop);

		request.getSession().setAttribute("showinfolist", showinfolist);
		request.getSession().setAttribute("showinfop", showinfop);
		
		
				
		request.getRequestDispatcher("pages/showinfo.jsp").forward(request, response);
		
	}
	public void ShowInfochange(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer index=Integer.parseInt(request.getParameter("index"));
		Integer id=(Integer)request.getSession().getAttribute("id");
		
		PageForum p=(PageForum)request.getSession().getAttribute("showinfop");
		
		p.setIndex(index);
		
		List<Map<String, Object>> showinfolist=dao.getShowInfo(id, p);
		request.getSession().setAttribute("showinfolist", showinfolist);
		request.getSession().setAttribute("showinfop", p);
		
		request.getRequestDispatcher("pages/showinfo.jsp").forward(request, response);
		
	}
	
	
	public void findByShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		List<Map<String,Object>> findlist=dao.findByShow(id);
		
		
		request.getSession().setAttribute("findlist", findlist);
		request.getSession().setAttribute("id", id);
		ShowInfo(request,response);
		
	}
	
	public void Add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fatie=request.getParameter("title");
		String neirong=request.getParameter("neirong");
		Integer id=Integer.parseInt(request.getParameter("hid"));
		dao.Add(fatie, neirong,id);
		GetInfo(request,response);
		
		
	}
	public void AddLiuyan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		Integer hddid=Integer.parseInt(request.getParameter("hddid"));
		Integer lid=(Integer)request.getSession().getAttribute("id");
		String liuyan=request.getParameter("liuyan");
		
		
		dao.AddLiuyan(hddid,lid,liuyan);
		ShowInfo(request,response);
		
		
	}

}
