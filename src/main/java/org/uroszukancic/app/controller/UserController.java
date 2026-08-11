package controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.User;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import service.UserService;

import java.util.List;

@Path("/users")
@Tag(name = "Users", description = "User data management")
public class UserController {

    @Inject
    UserService userService;

    @Operation(
            summary = "User creation",
            description = "Endpoint used for user creation, gets user data saves it in database " +
                    "TODO: Provide JSON for user DATA"

    )
    @RolesAllowed("user")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        User created = userService.createUser(user);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @Operation(
            summary = "Fetch user data by his ID",
            description = "This endpoint is used for returning data for specific User by his id (provided in path)"

    )
    @RolesAllowed("user")
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") Long id) {
        User user = userService.getUser(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(user).build();
    }

    @Operation(
            summary = "Fetch data for all users",
            description = "This endpoint is used for returning data for all Users"

    )
    @RolesAllowed("user")
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        List<User> users = userService.getAllUser();
        if (users == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(users).build();
    }
}