import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        return http.csrf { csrf: CsrfConfigurer<HttpSecurity> -> csrf.disable() }
            .sessionManagement { sm: SessionManagementConfigurer<HttpSecurity?> ->
                sm.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS
                )
            }
            .build()
    }
}


