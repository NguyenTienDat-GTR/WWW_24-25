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
import DAOImpl.DienThoaiDAOImpl;
import DAOImpl.NhaCungCapDAOImpl;
import Utils.EntityManagerFactoryUtil;
import entities.DienThoai;
import entities.NhaCungCap;

/**
 * Servlet implementation class DienThoaiController
 */
@WebServlet("/dienthoai")
public class DienThoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManagerFactory;
	private DienThoaiDAO dienThoaiDao;
	private NhaCungCapDAOImpl nhaCungCapDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DienThoaiController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.entityManagerFactory = new EntityManagerFactoryUtil();
		this.dienThoaiDao = new DienThoaiDAOImpl(this.entityManagerFactory.getEntityManager());
	}

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
			getFormAddDT(request, response);
			break;
		default:
			ListDienThoai(request, response);
			break;
		}
	}

	private void getFormAddDT(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		nhaCungCapDao = new NhaCungCapDAOImpl(this.entityManagerFactory.getEntityManager());
		List<NhaCungCap> listNhaCungCap = nhaCungCapDao.getAllNhaCungCap();
		request.setAttribute("listNCC", listNhaCungCap);
		request.getRequestDispatcher("views/FormAddDT.jsp").forward(request, response);

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
			insertDienThoai(request, response);
			break;
		default:
			ListDienThoai(request, response);
			break;
		}
	}

	private void ListDienThoai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<DienThoai> list = dienThoaiDao.getAllDienThoai();
		request.setAttribute("listDT", list);
		request.getRequestDispatcher("views/listDienThoai.jsp").forward(request, response);
	}

	private void insertDienThoai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tenDT = request.getParameter("txtTenDT");
		int namSX = Integer.parseInt(request.getParameter("txtNamSX"));
		String cauHinh = request.getParameter("txtCauHinh");
		int maNCC = Integer.parseInt(request.getParameter("txtMaNCC"));

		NhaCungCap nhaCungCap = nhaCungCapDao.getNhaCungCapByID(maNCC);

		DienThoai dt = new DienThoai();
		dt.setTenDT(tenDT);
		dt.setNamSX(namSX);
		dt.setCauHinh(cauHinh);
		dt.setNhaCungCap(nhaCungCap);

		DienThoai savedDienThoai = dienThoaiDao.saveDienThoai(dt);
		response.sendRedirect("dienthoai");

	}
}
