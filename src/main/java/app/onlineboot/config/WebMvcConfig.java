package app.onlineboot.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerCustomizer() {
        return container -> container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/index.html"));
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index"); /// /** does not return dist files
    }

    @Bean
    public ClassLoaderTemplateResolver indexHTMLTemplateResolver() {
        ClassLoaderTemplateResolver indexHTMLTemplateResolver = new ClassLoaderTemplateResolver();
        indexHTMLTemplateResolver.setPrefix("webapp/");
        indexHTMLTemplateResolver.setSuffix(".html");
        indexHTMLTemplateResolver.setTemplateMode(TemplateMode.HTML);
        indexHTMLTemplateResolver.setCharacterEncoding("UTF-8");
        indexHTMLTemplateResolver.setOrder(0);
        indexHTMLTemplateResolver.setCheckExistence(true);
        return indexHTMLTemplateResolver;
    }

}
