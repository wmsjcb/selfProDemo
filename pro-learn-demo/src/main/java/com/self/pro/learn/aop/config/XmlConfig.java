package com.self.pro.learn.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

@Configuration
public class XmlConfig {

    @Bean
    public Conf getConfXml() throws JAXBException, UnsupportedEncodingException {
        try {
            JAXBContext context = JAXBContext.newInstance(Conf.class);
            Unmarshaller u = context.createUnmarshaller();
            InputStream is =  new ByteArrayInputStream(testxml().getBytes("UTF-8"));
            //Conf rule = (Conf)u.unmarshal(XmlConfig.class.getResourceAsStream("/conf.xml"));
            Conf conf = (Conf)u.unmarshal(is);
            return conf;
        } catch (Exception e) {
            throw e;
        }
    }

    private String testxml() {
        return "<switch>\n" +
                "   <isopen>true</isopen>\n" +
                "   <iswhite>true</iswhite>\n" +
                "    <whitelist>\n" +
                "        <string>123</string>\n" +
                "        <string>456</string>\n" +
                "    </whitelist>\n" +
                "</switch>";
    }
}