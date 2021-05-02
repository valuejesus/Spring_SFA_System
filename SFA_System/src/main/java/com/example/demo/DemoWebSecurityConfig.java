package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import  com.example.demo.service.UserDetailsServiceImpl;
@EnableWebSecurity
@Configuration
class DemoWebSecurityConfig extends WebSecurityConfigurerAdapter {
	private MessageSource s = null;
	// UserDetailsServiceImplのメソッドを使えるようインスタンス化しておきます。
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    //フォームの値と比較するDBから取得したパスワードは暗号化されているのでフォームの値も暗号化するために利用
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // AUTHORIZE
            .authorizeRequests()
            .mvcMatchers("/original_login").permitAll()//original_
            .anyRequest()
            .authenticated()
            .and()
            // LOGIN
            .formLogin()
            // ▼今回追加
            /* */.loginPage("/original_login")
            /*    */.permitAll()
            // ▲今回追加

            .defaultSuccessUrl("/ClientList")
        // end
        ;
     // ▼今回追加
        // メッセージをカスタマイズするために、メッセージソースを設定する
        /*AuthenticationManager a = this.authenticationManager();
        if (a instanceof ProviderManager) {
            ProviderManager a2 = (ProviderManager)a;
            a2.getProviders().forEach(p -> {
                if (p instanceof MessageSourceAware) {
					((MessageSourceAware)p).setMessageSource(s);
                }
            });
        }*/
    }
	 @Autowired
	    public void configure(AuthenticationManagerBuilder auth) throws Exception{
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	        /*
	         * インメモリの場合は以下を使います。
	        auth
	            .inMemoryAuthentication()
	                .withUser("user").password("{noop}password").roles("USER");
	        */
	    }
   /* @Override
	protected void configure(HttpSecurity web)throws Exception{

		web.formLogin().loginPage("/original_login").defaultSuccessUrl("/inpg01").failureUrl("/login-error").permitAll();
		web.authorizeRequests().antMatchers("/css/**", "/images/**", "/js/**").permitAll().anyRequest().authenticated();
	}*/
}
