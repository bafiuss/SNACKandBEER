package model.bean;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "/AccessControlFilter", urlPatterns = "/*")
public class AccessControlFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		String str = (String) httpServletRequest.getSession().getAttribute("isAdmin");
		
		boolean isAdmin=false;
		if(str != null && str.equals("true"))
			isAdmin = true;
		
	
		String path = httpServletRequest.getServletPath();
		
		if ( (path.contains("/admin/") || path.contains("Admin")) && (!isAdmin)) {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/index.jsp");
			return;
		}
		
		if((!isAdmin) && (path.contains("InserimentoProdotto") || path.contains("InserimentoFinaleProdotto") || 
			 path.contains("RimozioneProdotto") || path.contains("ModificaProdotto") || path.contains("ModificaFinaleAdmin") || 
			 path.contains("UploadPhoto") || path.contains("ordAdmin")) ) 
		{
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/index.jsp");
			return;
		}
		
		
		chain.doFilter(request, response);
	}
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// init function
	}
	
	@Override
    public void destroy() {
		// destroy function
	}

	private static final long serialVersionUID = 1L;

}


	