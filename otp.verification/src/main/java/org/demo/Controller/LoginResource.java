package org.demo.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import org.demo.Service.LoginService;

@Path("/login")
public class LoginResource {

    @Inject
    private LoginService loginService;

    @GET
    @Path("/{login}")
    @Produces
    public String loginHandler(@PathParam("login")String login) {
        System.out.println(":::::::::::::::::::::::::"+login);
        return loginService.loginService(login);
    }

    @GET
    @Path("/{login}/{otp}")
    @Produces
    public String validateHandler(@PathParam("login")String login,@PathParam("otp")int otp) {
        System.out.println(otp+":::::::::::::::::::::::::"+login);
        return loginService.validateService(login,otp);
    }

}
