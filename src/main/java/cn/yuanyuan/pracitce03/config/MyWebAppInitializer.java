package cn.yuanyuan.pracitce03.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *  WebApplicationContext is possible to have a context hierarchy where one root WebApplicationContext
 *  is shared across multiple DispatcherServlet (or other Servlet) instances.
 *  WebApplicationContext可以被多个dispatcherservlet(或其他servlet)共享。
 *
 *  The root WebApplicationContext typically contains infrastructure beans,
 *  such as data repositories and business services
 *  that need to be shared across multiple Servlet instances.
 *  root webapplicationcontext 通常包括了基础bean，如：dao，servlet
 *  servlet webapplicationcontext依赖root webapplicationcontext
 *
 * 	If an application context hierarchy is not required, applications can
 * 	return all configuration through getRootConfigClasses() and null from getServletConfigClasses().
 * 如果不需要context hierarchy，getRootConfigClasses()返回所有配置，getServletConfigClasses()返回null。
 */
/*public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { AppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/app1/*" };
    }
}*/
