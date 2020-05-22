package com.glowpick.handler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;
import java.sql.SQLException;

public class ResultHandler
{
    /**
     *
     * @param body
     * @param conn
     * @return
     * @throws SQLException
     */
    public static ResponseEntity<Object> handle(Object body, Connection conn) throws SQLException
    {
        if (conn != null && !conn.isClosed()) conn.close();

        System.out.println("Connection is closed_" + conn.isClosed());

        return ResponseEntity.ok(body);
    }

    /**
     *
     * @param body
     * @return
     */
    public static ResponseEntity<?> handle(Object body)
    {
        if (body == null)
        {
            ResponseEntity.status(HttpStatus.NO_CONTENT);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(body);
    }

    /**
     *
     * @param conn
     * @return
     * @throws SQLException
     */
    public static ResponseEntity<?> handle(Connection conn) throws SQLException
    {
        if (conn != null && !conn.isClosed()) conn.close();

        System.out.println("Connection is closed_" + conn.isClosed());

        return ResponseEntity.ok().build();
    }
}
