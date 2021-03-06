package io.github.jklingsporn.vertx.jooq.shared.internal;

import org.jooq.Condition;

import java.util.Collection;

/**
 * @param <P> the POJO-type
 * @param <T> the Key-Type
 * @param <FIND_MANY> the result type returned for all findManyXYZ-operations. This varies on the VertxDAO-subtypes, e.g. {@code Future<List<P>>}.
 * @param <FIND_ONE> the result type returned for all findOneXYZ-operations. This varies on the VertxDAO-subtypes , e.g. {@code Future<P>}.
 * @param <EXECUTE> the result type returned for all insert, update and delete-operations. This varies on the VertxDAO-subtypes, e.g. {@code Future<Integer>}.
 * @param <INSERT_RETURNING> the result type returned for the insertReturning-operation. This varies on the VertxDAO-subtypes, e.g. {@code Future<T>}.
 * @see QueryExecutor
 */
public interface GenericVertxDAO<P, T, FIND_MANY, FIND_ONE, EXECUTE, INSERT_RETURNING>  {


    /**
     * Performs an async <code>INSERT</code> statement for a given POJO
     * @param pojo
     * @return the result type returned for all insert, update and delete-operations.
     */
    public EXECUTE insert(P pojo);

    /**
     * Performs an async <code>INSERT</code> statement for all given POJOs
     * @param pojos
     * @return the result type returned for all insert, update and delete-operations.
     */
    public EXECUTE insert(Collection<P> pojos);

    /**
     * Performs an async <code>INSERT</code> statement for a given POJO and returns it's primary key.
     * @param pojo
     * @return the result type returned for INSERT_RETURNING.
     */
    public INSERT_RETURNING insertReturningPrimary(P pojo);

    /**
     * Performs an async <code>UPDATE</code> statement for a given POJO. For performance reasons, consider writing
     * your own update-statements by using a <code>QueryExecutor</code> directly.
     * @param pojo
     * @return the result type returned for all insert, update and delete-operations.
     */
    public EXECUTE update(P pojo);

    /**
     * Performs an async <code>DELETE</code> statement using the given id
     * @param id
     * @return the result type returned for all insert, update and delete-operations.
     */
    public EXECUTE deleteById(T id);

    /**
     * Performs an async <code>DELETE</code> statement using the given ids
     * @param ids
     * @return the result type returned for all insert, update and delete-operations.
     */
    public EXECUTE deleteByIds(Collection<T> ids);

    /**
     * Performs an async <code>DELETE</code> statement using the given <code>Condition</code>
     * @param condition
     * @return the result type returned for all insert, update and delete-operations.
     */
    public EXECUTE deleteByCondition(Condition condition);

    /**
     * Performs an async <code>SELECT</code> using the given condition. If more than one row is found, a
     * <code>TooManyRowsException</code> is raised.
     * @param condition
     * @return the result type returned for all find-one-value-operations.
     */
    public FIND_ONE findOneByCondition(Condition condition);

    /**
     * Performs an async <code>SELECT</code> using the given primary key.
     * @param id
     * @return the result type returned for all find-one-value-operations.
     */
    public FIND_ONE findOneById(T id);

    /**
     * Performs an async <code>SELECT</code> using the given primary keys.
     * @param ids
     * @return the result type returned for all find-many-values-operations.
     */
    public FIND_MANY findManyByIds(Collection<T> ids);

    /**
     * Performs an async <code>SELECT</code> using the given condition.
     * @param condition
     * @return the result type returned for all find-many-values-operations.
     */
    public FIND_MANY findManyByCondition(Condition condition);

    /**
     * Performs an async <code>SELECT</code>.
     * @return the result type returned for all find-many-values-operations.
     */
    public FIND_MANY findAll();

}
