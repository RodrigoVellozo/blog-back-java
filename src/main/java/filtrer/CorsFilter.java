package filtrer;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(asyncSupported=true, urlPatterns= {"/*"})
public class CorsFilter implements Filter {

    public CorsFilter() {
      
    }

    public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse resp = (HttpServletResponse)response;
		
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE,OPTIONS");
		resp.addHeader("Access-Control-Allow-Headers", "Content-Type");
		resp.addHeader("allow", "POST,GET,PUT,DELETE,OPTIONS");
		
		chain.doFilter(request, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
