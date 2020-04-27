package org.acme.getting.started;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.SqlResult;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    PgPool dbClient;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<Integer> hello() {
        return dbClient.query("SELECT 1")
                .map(SqlResult::rowCount);
    }
}
