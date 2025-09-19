package ru.netology.AppConfig;

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
