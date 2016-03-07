package org.sanelib.ils.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.sanelib.ils.common.utils.LoggingStopWatch;
import org.sanelib.ils.common.utils.LoggingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static Logger SERVICE_LOGGER = LoggerFactory.getLogger("service_logger");

    private static final String METHOD_EXECUTION_SERVICE = "method[{}], exec_time = {}ms, input = {}; output = {}";

    @Around("within(org.sanelib.ils.api.services..*) and !execution(* org.sanelib.ils.common.session.UserSession.*(..)) "
			+ " and !@annotation(org.sanelib.ils.common.aspect.DisableLogging)")
    public Object logForService(ProceedingJoinPoint jointPoint) throws Throwable {
        Object point = null;
        LoggingStopWatch stopwatch = new LoggingStopWatch();
        Throwable thrown = null;
        String req = LoggingUtil.buildArgInfoString(jointPoint.getArgs());
        try {

            stopwatch.start();
            point = jointPoint.proceed();

        } catch (Throwable t) {
            thrown = t;
            throw t;
        } finally {
            long time = stopwatch.stop();
            if (thrown != null) {
                SERVICE_LOGGER.warn(METHOD_EXECUTION_SERVICE,new Object[] { jointPoint.toShortString(), time, req,thrown });
            } else {
                SERVICE_LOGGER.info(METHOD_EXECUTION_SERVICE,new Object[] {jointPoint.toShortString(),time,req,
                        (point == null ? point : point.getClass().isArray() ? LoggingUtil.arrayToString(point).replaceAll("\\\n", "") : point
                                .toString().replaceAll("\\\n", "")) });

            }
        }
        return point;
    }
}
