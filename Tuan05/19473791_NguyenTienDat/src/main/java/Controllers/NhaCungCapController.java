package Controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import DAO.DienThoaiDAO;
import DAO.NhaCungCapDAO;
import DAOImpl.NhaCungCapDAOImpl;
import Utils.EntityManagerFactoryUtil;
import entities.NhaCungCap;

/**
 * Servlet implementation class NhaCungCapController
 */
public class NhaCungCapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManagerFactory;
	private NhaCungCapDAO nhaCungCapDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NhaCungCapController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.entityManagerFactory = new EntityManagerFactoryUtil();
		this.nhaCungCapDao = new NhaCungCapDAOImpl(this.entityManagerFactory.getEntityManager());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		this.entityManagerFactory.close();
		super.destroy();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		System.out.println(action);
		switch (action) {
		case "new":
			showInsertForm(request, response);
			break;
		default:
			listNhaCungCap(request, response);
			break;

		}
	}

	private void showInsertForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/FormAddNCC.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		System.out.println(action);
		switch (action) {
		case "insert":
			insertNCC(request, response);
			break;
		default:
			listNhaCungCap(request, response);
			break;
		}
	}

	private void listNhaCungCap(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<NhaCungCap> list = nhaCungCapDao.getAllNhaCungCap();
		System.out.println("Danh sách nhà cung cấp: " + list);
		request.setAttribute("listNCC", list);
		request.getRequestDispatcher("views/listNhaCungCap.jsp").forward(request, response);
	}

	private void insertNCC(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tenNCC = request.getParameter("txtTenNCC");
		String diaChi = request.getParameter("txtDiaChi");
		String sdt = request.getParameter("txtSdt");

		NhaCungCap ncc = new NhaCungCap();
		ncc.setTenNCC(tenNCC);
		ncc.setDiaChi(diaChi);
		ncc.setSdt(sdt);

		nhaCungCapDao.saveNhaCungCap(ncc);
		response.sendRedirect("nhacungcap");

	}

}
