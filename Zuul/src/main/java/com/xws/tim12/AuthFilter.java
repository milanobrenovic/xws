package com.xws.tim12;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.xws.tim12.security.JwtAuthenticationRequest;

import feign.FeignException;

@Component
public class AuthFilter extends ZuulFilter{

	@Autowired
	private AuthClient authClient;
	
	@Override
	public String filterType() {
		return "pre";
	}
	
	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		if(request.getHeader("Authorization") == null) {
			return null;
		}
		
		//String username = request.getHeader("username");
		//String password = request.getHeader("password");
		
		String authRequest = request.getHeader("Authorization");
		System.out.println("**************************" + authRequest);
		try {
			//authClient.login(authRequest);
			ctx.addZuulRequestHeader("Authorization", authRequest);
			//ctx.addZuulRequestHeader("password", password);
			//ctx.addZuulRequestHeader("role", "NORMAL_USER");
		} catch (FeignException.NotFound e) {
			setFailedRequest("User does not exist", 403);
		}
		
		return null;
	}
	
    private void setFailedRequest(String body, int code) {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody(body);
            ctx.setSendZuulResponse(false);
        }
    }
}
