package com.cassio.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InfoService {
	@Autowired
	private Environment env;
	
	@Value("${version}")
	private String version;
	
	@Value("${build.date}")
	private String buildDate;
	
	@RequestMapping("/")
    @ResponseBody
    public String info() {
	    version = env.getProperty("version");
	    buildDate = env.getProperty("build.date");
	    
	    StringBuilder sb = new StringBuilder();
        sb.append("Versão da aplicação: %s");
        sb.append("<BR/>");
        sb.append("Data do build: %s");
        
        return String.format(sb.toString(), version, buildDate);
    }
}
