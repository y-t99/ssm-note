package cn.yuanyuan.practice01;

import cn.yuanyuan.practice01.config.MyConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * 	In addition to using the ServletContext API directly,
 * 	you can also extend AbstractAnnotationConfigDispatcherServletInitializer
 * 	and override specific methods (see the example under Context Hierarchy).
 * 	除了使用ServletContext API来配置前端控制器，还可以利用
 * 	AbstractAnnotationConfigDispatcherServletInitializer
 * 	具体参考Context Hierarchy
 *
 * 	Spring Boot follows a different initialization sequence.
 * 	Rather than hooking into the lifecycle of the Servlet container,
 * 	Spring Boot uses Spring configuration to bootstrap itself and the embedded Servlet container.
 * 	Filter and Servlet declarations are detected in Spring configuration and registered with the Servlet container.
 * 	For more details, see the Spring Boot documentation.
 * 	springboot不是依赖于servlet container，而是使用内嵌了spring容器功能。
 *
 *  WebApplicationInitializer is an interface provided by Spring MVC
 *  that ensures your implementation is detected and automatically used
 *  to initialize any Servlet 3 container.
 *  An abstract base class implementation of WebApplicationInitializer named AbstractDispatcherServletInitializer
 *  makes it even easier to register the DispatcherServlet
 *  by overriding methods to specify the servlet mapping
 *  and the location of the DispatcherServlet configuration.
 *  WebApplicationInitializer接口让类被容器识别到，达到可以进行配置的目的。
 *  覆盖方法进行servlet mapping 和 dispatcherservlet 的配置。
 * AbstractDispatcherServletInitializer是实现WebApplicationInitializer的抽象类，
 * 使webapplication配置更容易。
 */
public class MyWebApplicationInitializer {
    /**
     *  DispatcherServlet expects a WebApplicationContext (an extension of a plain ApplicationContext) for its own configuration.
     *  WebApplicationContext has a link to the ServletContext and the Servlet with which it is associated.
     *  It is also bound to the ServletContext such that applications can use static methods on RequestContextUtils
     *  to look up the WebApplicationContext if they need access to it.
     *  dispatcherservlet期待一个webapplicationcontext(web应用程序上下文)。
     *  webapplicationcontext有一个对servletcontext及其相关servlet的引用。
     *  dispatcherservlet还可以绑定到servletcontext。
     * @param servletCxt
     */
    //implements WebApplicationInitializer
    //@Override
    public void onStartup(ServletContext servletCxt) {

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(MyConfig.class);
//        DelegatingWebMvcConfiguration: Bean instantiation via factory method failed;
//        发生报错
        ac.refresh();

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app/*");

        System.out.println("进行初始化配置");
    }
}
