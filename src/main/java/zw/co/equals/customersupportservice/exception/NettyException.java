package zw.co.equals.customersupportservice.exception;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum NettyException {
    READ_TIMEOUT("io.netty.handler.timeout.ReadTimeoutException"),
    WRITE_TIMEOUT("io.netty.handler.timeout.WriteTimeoutException"),
    CONNECTION_TIMEOUT("io.netty.channel.ConnectTimeoutException"),

    CHANNEL_TIMEOUT("io.netty.channel.AbstractChannel$AnnotatedConnectException");

    private final String classPath;

     NettyException(String classPath) {
        this.classPath = classPath;
    }

    public static Optional<NettyException> valueOfClassPath(String classPath) {
        Objects.requireNonNull(classPath);
        return Arrays.stream(NettyException.values())
                .filter(e -> e.classPath.equals(classPath))
                .findAny();
    }
}
