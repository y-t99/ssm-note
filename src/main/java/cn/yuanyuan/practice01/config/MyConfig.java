package cn.yuanyuan.practice01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.ServletContext;
import java.io.IOException;

@Configuration
@EnableWebMvc
@ComponentScan("cn.yuanyuan.practice01")
public class MyConfig implements WebMvcConfigurer {
/**
 * The DispatcherServlet delegates to special beans
 * to process requests and render the appropriate responses.
 * By “special beans” we mean Spring-managed Object instances
 * that implement framework contracts.
 * Those usually come with built-in contracts,
 * but you can customize their properties and extend or replace them.
 * dispatcherservlet依赖于一些特殊的bean来处理请求。
 * 这些特殊的bean有spring定制，当然，我们可以自定义扩展或者替代他们。
 *
 * 几个特殊的bean介绍：
 * HandlerMapping
 * Map a request to a handler along with a list of interceptors for pre- and post-processing.
 * 将请求与处理器映射起来，通过一系类的请求拦截和前置处理。
 *
 * The two main HandlerMapping implementations are RequestMappingHandlerMapping
 * (which supports @RequestMapping annotated methods)
 * and SimpleUrlHandlerMapping
 * (which maintains explicit registrations of URI path patterns to handlers).
 * 两个主要的HandlerMapping实现是RequestMappingHandlerMapping(它支持@RequestMapping注释的方法)
 * 和SimpleUrlHandlerMapping(它维护URI路径模式到处理程序的显式注册)。
 *
 * HandlerAdapter
 * Help the DispatcherServlet to invoke a handler mapped to a request,
 * regardless of how the handler is actually invoked.
 * dispatcherservlet转发作用，而不关心具体处理细节。HandlerAdapter起处理细节作用。
 *
 * HandlerExceptionResolver
 * Strategy to resolve exceptions, possibly mapping them to handlers, to HTML error views, or other targets.
 * 发生异常时的后续处理。
 *
 * ViewResolver
 * Resolve logical String-based view names returned from a handler to an actual View with which to render to the response.
 * 将从处理程序返回的基于逻辑字符串的视图名称解析为要呈现给响应的实际视图。
 */
/*
    register interceptors to apply to incoming requests
    设置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/xx/**");
    }
*/
    /*
        对于不需要进行控制处理的视图，直接与url进行转换。

        If an @RequestMapping method is mapped to a URL for any HTTP method
        then a view controller cannot be used to handle the same URL.
        如果@RequestMapping方法映射到任何HTTP方法的URL，则视图控制器不能用于处理相同的URL。
        否则会出错。
    */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/form").setViewName("form");
    }

    //静态文件的位置，还可以设置静态文件被存储的时间。setCachePeriod(31556926)其他高级配置。
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
            .addResourceLocations("/public", "classpath:/static/");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.enableContentNegotiation(new InternalResourceView());
        registry.jsp("/static/",".jsp");
    }

    @Bean@Autowired
    public MultipartResolver multipartResolver(ServletContext servletContext){
        final CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        //默认编码
        multipartResolver.setDefaultEncoding("UTF-8");
        //最大的文件大小：5MB
        multipartResolver.setMaxUploadSize(5*1024*1024);
        //文件内存最大缓存大小：5KB 默认1kb
        multipartResolver.setMaxInMemorySize(5*1024);
        //超过内存最大缓存时：文件的暂存位置
//        final ServletContextResource resource = new ServletContextResource(servletContext, "/WEB-INF/temp");
        final FileSystemResource resource = new FileSystemResource("d://temp");
        try {
            multipartResolver.setUploadTempDir(resource);
        } catch (IOException e) {
            System.out.println("路径不存在");
        }
        //是否延迟文件解析
        multipartResolver.setResolveLazily(false);
        return multipartResolver;
    }
/*
其他配置：
    configure how Spring MVC determines the requested media types from the request
    配置如何从request中确定请求的媒体类型。

    The MVC configuration simplifies the registration of view resolvers.
    视图解析器配置。
    Note, however, that FreeMarker, Tiles, Groovy Markup, and script templates
    also require configuration of the underlying view technology.

    Spring MVC allows for mapping the DispatcherServlet to /
    (thus overriding the mapping of the container’s default Servlet),
     while still allowing static resource requests to be handled
     by the container’s default Servlet.
     It configures a DefaultServletHttpRequestHandler with a URL mapping of /**
     and the lowest priority relative to other URL mappings.
     配置default servlet

     自定义全局验证器实例

     自定义格式转换器。

     If an exception occurs during request mapping
     or is thrown from a request handler (such as a @Controller),
     the DispatcherServlet delegates to a chain of HandlerExceptionResolver beans
     to resolve the exception and provide alternative handling,
     which is typically an error response.
     如果发生异常，a chain of HandlerExceptionResolver beans将进行后续处理

    To enable multipart handling, you need
    to declare a MultipartResolver bean in your DispatcherServlet Spring configuration
    with a name of multipartResolver.
    The DispatcherServlet detects it and applies it
    to the incoming request.
    When a POST with content-type of multipart/form-data is received,
    the resolver parses the content and
    wraps the current HttpServletRequest as MultipartHttpServletRequest
    to provide access to resolved parts in addition
    to exposing them as request parameters.
    多媒体类型的传输需要配置多媒体解析，spring mvc将自动为我们进行识别。
    There is one implementation based on Commons FileUpload
    and another based on Servlet 3.0 multipart request parsing.
    spring mvc的文件上下传基于commons fileupload和servlet 3.0
 */
}
