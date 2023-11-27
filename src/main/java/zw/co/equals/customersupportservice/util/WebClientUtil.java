package zw.co.equals.customersupportservice.util;

import lombok.extern.slf4j.Slf4j;
import zw.co.equals.customersupportservice.exception.ApiConnectionTimeOutException;
import zw.co.equals.customersupportservice.exception.ApiReadTimeOutException;
import zw.co.equals.customersupportservice.exception.ApiWriteTimeOutException;
import zw.co.equals.customersupportservice.exception.NettyException;

import java.util.Optional;

@Slf4j
public class WebClientUtil {

    public static void handleNettyExceptions(Throwable throwable) {
        if (throwable.getCause() != null) {
            String classPath = throwable.getCause().getClass().getName();
            log.info("An exception of type : {}, occurred.", classPath);
            Optional<NettyException> nettyExceptionOpt = NettyException.valueOfClassPath(classPath);
            if (nettyExceptionOpt.isPresent()) {
                NettyException nettyException = nettyExceptionOpt.get();
                switch (nettyException) {
                    case READ_TIMEOUT:
                        throw new ApiReadTimeOutException("ReadTimeOut exception.");
                    case WRITE_TIMEOUT:
                        throw new ApiWriteTimeOutException("WriteTimeOut exception.");
                    case CONNECTION_TIMEOUT, CHANNEL_TIMEOUT:
                        throw new ApiConnectionTimeOutException("ConnectionTimeOut timeout exception.");
                }
            }
        }
    }
}
