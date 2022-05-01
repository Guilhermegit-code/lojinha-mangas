package br.com.otakusgroup.lojinha.dataprovider.persistence

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.core.JdbcTemplate

@Configuration
class JdbcConfig {

    @Bean
    @Primary
    @ConfigurationProperties("app.db")
    fun criaConexao(): HikariDataSource = DataSourceBuilder.create().type(HikariDataSource::class.java).build()


}