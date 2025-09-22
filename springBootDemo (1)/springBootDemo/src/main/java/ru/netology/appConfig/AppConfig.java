package ru.netology.appConfig;

import ru.netology.profile.DevProfile;
import ru.netology.profile.ProductionProfile;
import ru.netology.profile.SystemProfile;

public class AppConfig {
    @Configuration
    @EnableWebMvc
    @ComponentScan(basePackages = "netology")
    public class AppConfig implements WebMvcConfigurer {
        @Bean
        @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "true")
        public SystemProfile devProfile() {
            return new DevProfile();
        }

        @Bean
        @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "false", matchIfMissing = true)
        public SystemProfile prodProfile() {
            return new ProductionProfile();
        }
    }
}
