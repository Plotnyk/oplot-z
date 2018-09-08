package rest.controller.base;

import javax.ws.rs.core.Response;

/**
 * Base class for all REST web-services
 *
 * @author Plotnik
 *
 */
public abstract class BaseException {

    /**Shared Exception that should be returned if requested operation
     * returns no datd (404)
     */
    protected final Response NOT_FOUND;

    /**
     * Returned if client sends request in invalid or unsupported format
     * (400)
     */
    protected final Response BAD_REQUEST;

    public BaseException() {
        NOT_FOUND = Response.status(Response.Status.NOT_FOUND).build();

        BAD_REQUEST = Response.status(Response.Status.BAD_REQUEST).build();
    }

    /**
     * Returns operation result as Response object
     *
     * @param result
     * @return
     */
    protected Response ok(Object result) {
        return Response.ok(result).build();
    }
}
