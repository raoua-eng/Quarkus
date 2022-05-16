package org.acme.utils.security;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.Priorities;

import org.eclipse.microprofile.jwt.JsonWebToken;

@Secured
@Interceptor
@Priority(Priorities.AUTHENTICATION)
public class SecurityInterceptor {
	@Inject
	JsonWebToken jwt;

	@AroundInvoke
	public Object filter(InvocationContext context) throws Exception {
		if (jwt != null) {
			if (hasJwt()) {
				System.out.println(jwt.getClaimNames());
				return context.proceed();
			} else {
				throw new Exception("Invalid Json Web Token");
			}
		} else {
			throw new Exception("No token available");
		}
	}

	private boolean hasJwt() {
		return jwt.getClaimNames() != null;
	}
}
