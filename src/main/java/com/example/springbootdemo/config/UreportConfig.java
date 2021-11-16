package com.example.springbootdemo.config;

import com.bstek.ureport.console.UReportServlet;
import com.bstek.ureport.definition.datasource.BuildinDatasource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2021/9/16 9:17</br>
 * @since JDK 1.8
 */

@ImportResource("classpath:ureport-console-context.xml")//不加项目能够启动但是会导致加载数据源报错或加载不了
@Configuration
@EnableAutoConfiguration
@Slf4j
public class UreportConfig implements BuildinDatasource {
	@Resource
	DataSource dataSource;

	@Bean //定义ureport的启动servlet
	public ServletRegistrationBean buildUreportServlet(){
		return new ServletRegistrationBean(new UReportServlet(),"/ureport/*");
	}

	@Override
	public String name() {
		return "System";
	}

	@Override
	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			log.error("Ureport 数据源 获取连接失败！");
			e.printStackTrace();
		}
		return null;
	}

}
