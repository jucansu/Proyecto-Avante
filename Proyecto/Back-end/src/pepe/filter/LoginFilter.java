package pepe.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		Enumeration<String> aa = request.getHeaderNames();
		String token = request.getHeader("Authorization");
		token = token == null || token.isEmpty()? "" : token.substring(36, token.length()-36);
		int id = 0;
		try {
			id = Integer.parseInt(token);
			Boolean isValid = true;//id == servletRequest.; //comprobar si el token es valido
			
			if(!isValid) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}
		} catch (Exception err) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
		
		chain.doFilter(request, servletResponse);
        
    }

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
