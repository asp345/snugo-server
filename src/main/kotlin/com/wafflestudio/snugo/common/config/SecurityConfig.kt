package com.wafflestudio.snugo.common.config

import com.wafflestudio.snugo.common.auth.AuthFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.security.web.firewall.DefaultHttpFirewall
import org.springframework.security.web.firewall.HttpFirewall

@Configuration
@EnableWebSecurity(debug = false)
class SecurityConfig {

	@Bean
	fun securityFilterChain(http: HttpSecurity, authFilter: AuthFilter): SecurityFilterChain {
		http {
			csrf { disable() }
			addFilterAfter<BasicAuthenticationFilter>(authFilter)
			authorizeHttpRequests {
				authorize("/v1/user/register", permitAll)
				authorize("/v1/departments", permitAll)
				authorize("/swagger-ui/**", permitAll)
				authorize("/v3/api-docs/**", permitAll)
				authorize("/swagger-resources/**", permitAll)
				authorize(anyRequest, authenticated)
			}
		}
		return http.build()
	}

	@Bean
	fun httpFirewall(): HttpFirewall {
		return DefaultHttpFirewall()
	}
}
