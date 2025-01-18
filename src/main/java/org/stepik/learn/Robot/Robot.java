package org.stepik.learn.Robot;

public class Robot {
    private int x;
    private int y;
    private Direction direction;

    public static void moveRobot(Robot robot, int toX, int toY) {
        while (true) {
            if (robot.getY() != toY) {
                if (toY > 0) {
                    if (robot.getDirection() != Direction.UP) {
                        if (robot.getDirection() == Direction.LEFT) {
                            robot.turnRight();
                        } else if (robot.getDirection() == Direction.DOWN) {
                            robot.turnLeft();
                            robot.turnLeft();
                        } else {
                            robot.turnLeft();
                        }
                    }
                } else {
                    if (robot.getDirection() != Direction.DOWN) {
                        if (robot.getDirection() == Direction.LEFT) {
                            robot.turnLeft();
                        } else if (robot.getDirection() == Direction.UP) {
                            robot.turnLeft();
                            robot.turnLeft();
                        } else {
                            robot.turnRight();
                        }
                    }
                }
                robot.stepForward();
                continue;
            }
            if (robot.getX() != toX) {
                if (toX > 0) {
                    if (robot.getDirection() != Direction.RIGHT) {
                        if (robot.getDirection() == Direction.UP) {
                            robot.turnRight();
                        } else if (robot.getDirection() == Direction.DOWN) {
                            robot.turnLeft();
                        } else {
                            robot.turnLeft();
                            robot.turnLeft();
                        }
                    }
                } else {
                    if (robot.getDirection() != Direction.LEFT) {
                        if (robot.getDirection() == Direction.UP) {
                            robot.turnLeft();
                        } else if (robot.getDirection() == Direction.DOWN) {
                            robot.turnRight();
                        } else {
                            robot.turnLeft();
                            robot.turnLeft();
                        }
                    }
                }
                robot.stepForward();
                continue;
            }
            break;
        }
    }

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void turnLeft() {
        switch (direction) {
            case LEFT: {
                direction = Direction.DOWN;
                break;
            }
            case RIGHT: {
                direction = Direction.UP;
                break;
            }
            case UP: {
                direction = Direction.LEFT;
                break;
            }
            case DOWN: {
                direction = Direction.RIGHT;
                break;
            }
        }
    }

    private void turnRight() {
        switch (direction) {
            case LEFT: {
                direction = Direction.UP;
                break;
            }
            case RIGHT: {
                direction = Direction.DOWN;
                break;
            }
            case UP: {
                direction = Direction.RIGHT;
                break;
            }
            case DOWN: {
                direction = Direction.LEFT;
                break;
            }
        }
    }

    private void stepForward() {
        switch (direction) {
            case LEFT: {
                this.x -= 1;
                break;
            }
            case RIGHT: {
                this.x += 1;
                break;
            }
            case UP: {
                this.y += 1;
                break;
            }
            case DOWN: {
                this.y -= 1;
                break;
            }
        }
    }
}
