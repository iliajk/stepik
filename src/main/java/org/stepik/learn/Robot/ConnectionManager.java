package org.stepik.learn.Robot;

public class ConnectionManager implements RobotConnectionManager {
    RobotConnection connection;
    @Override
    public RobotConnection getConnection() {
        return connection;
    }
}
