package net.k_yokoi.sample.monolith.to.microservice.chat.app.web.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, Authentication authentication)
            throws IOException, ServletException {
        httpServletResponse.sendRedirect("/portal");
    }

}
