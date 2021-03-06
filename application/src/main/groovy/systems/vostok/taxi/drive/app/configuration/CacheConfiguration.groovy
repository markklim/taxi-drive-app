package systems.vostok.taxi.drive.app.configuration

import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.ehcache.EhCacheCacheManager
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource

@Configuration
@EnableCaching
class CacheConfiguration {
    @Bean
    CacheManager getEhCacheManager(){
        new EhCacheCacheManager(getEhCacheFactory().getObject())
    }

    @Bean
    EhCacheManagerFactoryBean getEhCacheFactory(){
        new EhCacheManagerFactoryBean().with{
            it.setConfigLocation(new ClassPathResource('ehcache.xml'))
            it.setShared(true)
            it
        }
    }
}
