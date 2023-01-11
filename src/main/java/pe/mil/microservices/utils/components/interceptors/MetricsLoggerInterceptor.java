package pe.mil.microservices.utils.components.interceptors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pe.mil.microservices.utils.components.helpers.ContextCurrentTimeHelper;
import pe.mil.microservices.utils.constants.BaseInterceptorConstants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MetricsLoggerInterceptor implements HandlerInterceptor {
    private static final Logger logger = LogManager.getLogger(MetricsLoggerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long start = ContextCurrentTimeHelper.getStarTime();
        logger.info("[{}]: [{}]", BaseInterceptorConstants.REQUEST_START_TIME, ContextCurrentTimeHelper.getTimestamp(start));
        request.setAttribute(BaseInterceptorConstants.REQUEST_START_TIME, start);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long start = (long) request.getAttribute(BaseInterceptorConstants.REQUEST_START_TIME);
        logger.info(BaseInterceptorConstants.REQUEST_TIME_RESPONSE_MESSAGE, ContextCurrentTimeHelper.getTotalTime(start));
    }
}