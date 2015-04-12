package lan.dk.podcastserver.config;

import lan.dk.podcastserver.service.PodcastServerParameters;
import lan.dk.podcastserver.utils.jackson.CustomObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Configuration de la partie Web MVC de l'application
 * Plus d'informations sur le configuration Java-Config de Spring MVC : http://www.luckyryan.com/2013/02/07/migrate-spring-mvc-servlet-xml-to-java-config/
 */
@Configuration
@ComponentScan("lan.dk.podcastserver.controller")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Resource PodcastServerParameters podcastServerParameters;

    public static final int CACHE_PERIOD = 31556926;
    public static final String PODCAST_LOCATION_RESOURCE_HANDLER = "/podcast/**";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("Mapping du dossier {} à {}", PODCAST_LOCATION_RESOURCE_HANDLER, podcastServerParameters.rootFolderWithProtocol());
        
        registry
                .addResourceHandler(PODCAST_LOCATION_RESOURCE_HANDLER)
                    .addResourceLocations(podcastServerParameters.rootFolderWithProtocol())
                    .setCachePeriod(CACHE_PERIOD);
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".html");
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureMessageConverters (List<HttpMessageConverter<?>> converters) {

        super.configureMessageConverters(converters);

        //Ajout de la librairie de désierialization spécifiques à Hibernate pour Jackson
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(new CustomObjectMapper());

        converters.add(mappingJackson2HttpMessageConverter);

        //Ajout du mapping string par défaut :
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(stringHttpMessageConverter);
    }

}