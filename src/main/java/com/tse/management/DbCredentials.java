package com.tse.management;

public class DbCredentials {
    private final String connectionString;

    public DbCredentials() {
        connectionString = "jdbc:postgresql://localhost:5432/booking?user=postgres&password=root";
    }

    public String getConnectionString() {
        return connectionString;
    }
}
