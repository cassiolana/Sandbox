package com.cassio.study.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Controller
public class InfoService {
	
	Logger logger = LoggerFactory.getLogger(InfoService.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;
	
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
	
	@RequestMapping("/index")
    public String index(Model model) {
		model.addAttribute("version", env.getProperty("version"));
		model.addAttribute("buildDate", env.getProperty("build.date"));
		model.addAttribute("endPoints", requestMappingHandlerMapping.getHandlerMethods().keySet());
        return "index";
    }

}
